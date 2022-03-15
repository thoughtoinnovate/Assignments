package org.assignments.problems.Strings;

import java.util.Stack;

public class MathsExpressionParser {


    /**
     * 3 + 4 * 5 = 23
     *
     * @return int value
     */
    public static int calculate(String input) {

        //BODMAS
        String precendence = "/*+-";

        Stack<Character> operationStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int startIndex = 0;

        //Check initial signed numbers
        if (isSigned(input.charAt(startIndex))) {

            numberStack.push(-(int) (input.charAt(startIndex + 1) - '0'));
            startIndex += 2;

        }

        //Used for handling any digit number
        StringBuilder numberBuilder = new StringBuilder();

        //push into the stack
        for (int i = startIndex; i < input.length(); i++) {

            //If Operation
            if (precendence.contains(String.valueOf(input.charAt(i)))) {

                //Get Number as number ends before an operation
                if (!numberBuilder.isEmpty()) {
                    numberStack.push(Integer.valueOf(numberBuilder.toString()));
                    numberBuilder = new StringBuilder();
                }

                if (operationStack.isEmpty()) {
                    operationStack.push(input.charAt(i));
                } else {
                    Character prevOp = operationStack.peek();
                    Character curOp = input.charAt(i);

                    //check for BODMAS rule
                    if (precendence.indexOf(curOp) > precendence.indexOf(prevOp)) {

                        //Swap the operation order as the current operation has lower priority then previous one
                        prevOp = operationStack.pop();
                        operationStack.push(curOp);
                        operationStack.push(prevOp);

                        //pop number stack, safety size check
                        if (numberStack.size() > 1) {

                            Integer second = numberStack.pop();
                            Integer first = numberStack.pop();

                            numberStack.push(doOperation(first, second, operationStack.pop()));
                        }
                    } else {
                        operationStack.push(curOp);
                    }
                }
            } else {

                //Build multi digit number
                numberBuilder.append(String.valueOf(input.charAt(i)));

                //If number is at the end of the expression
                if (i == input.length() - 1) {
                    numberStack.push(Integer.valueOf(numberBuilder.toString()));
                }

                //Incase of igned number with negative values add sign to the number
                if (!operationStack.isEmpty() && isSigned(operationStack.peek())) {
                    operationStack.pop();
                    operationStack.push('+');
                    numberBuilder.insert(0, '-');
                }

            }


        }

        //Apply all operation to the number stack
        while (!numberStack.isEmpty() && !operationStack.isEmpty()) {

            Integer second = numberStack.pop();
            Integer first = numberStack.pop();

            numberStack.push(doOperation(first, second, operationStack.pop()));

        }


        return numberStack.pop();
    }

    private static boolean isSigned(Character val) {
        return '-' == val;
    }

    private static Integer doOperation(Integer one, Integer two, Character operation) {

        Integer result = 0;
        if ('*' == operation) {
            result = one * two;
        } else if ('+' == operation) {
            result = one + two;
        } else if ('-' == operation) {
            result = one - two;
        } else if ('/' == operation) {
            result = one / two;
        }
        return result;
    }


    public static void main(String[] args) {

        //System.out.println(calculate("444/2*33-101-3+1333"));
        System.out.println(calculate("-1-5+3"));
    }
}
