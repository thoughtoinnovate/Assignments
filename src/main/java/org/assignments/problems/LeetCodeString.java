package org.assignments.problems;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeString {


    public static boolean isAlienSorted(String[] words, String order) {

        int totalWords = words.length;

        //put order in a map
        Map<Character, Integer> orderMap = new HashMap<>();

        int priority = 0;

        //O(N)
        for (Character chr : order.toCharArray()) {
            orderMap.put(chr, priority);
            priority++;
        }


        //O(N2)
        for (int indx = 0; indx < totalWords - 1; indx++) {

            String firstWord = words[indx];
            String secondWord = words[indx + 1];

            int firstWordLength = firstWord.length();
            int secondWordLength = secondWord.length();

            int smallerLength = (firstWordLength > secondWordLength) ? secondWordLength : firstWordLength;

            //word character loop
            for (int j = 0; j < smallerLength; j++) {


                if (orderMap.get(secondWord.charAt(j)) < orderMap.get(firstWord.charAt(j))) {

                    return false;
                } else if (secondWord.charAt(j) == firstWord.charAt(j)) {
                    if (j == smallerLength - 1 && secondWordLength < firstWordLength) {
                        return false;
                    }
                    continue;
                } else {
                    break;
                }
            }

        }

        return true;


    }


    public static void main(String[] args) {

        String[] firstArray = {"hello", "leetcode"};
        String[] secondArray = {"word", "world", "row"};
        String[] thirdArray = {"apple", "app"};
        //wordArray[0] = "w";
        //wordArray[1] = "leetcode";
        //wordArray[2] = "cbd";


        //first Test Case
        System.out.println(isAlienSorted(firstArray, "hlabcdefgijkmnopqrstuvwxyz"));
        // second Case
        System.out.println(isAlienSorted(secondArray, "worldabcefghijkmnpqstuvxyz"));
        //third Test Case
        System.out.println(isAlienSorted(thirdArray, "abcdefghijklmnopqrstuvwxyz"));


    }

}
