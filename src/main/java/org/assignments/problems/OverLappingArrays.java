package org.assignments.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OverLappingArrays {

    /**
     * BruteForce
     * Problem : Merge Overlapping Intervals
     * Intervals: [[1,4], [2,5], [7,9]]
     * [[1,4], [2,5], [3,9],[1,10]==> [1,10]
     * Output: [[1,5], [7,9]]
     */
    public static List<List<Integer>> mergeOverlappingIntervals(List<List<Integer>> input) {


        List<List<Integer>> nonOverlapping = new ArrayList<>();
        //Integer lowerBound = 0;
        //Integer upperBound = 0;
        HashSet<String> traversedSet = new HashSet<>();

        for (int i = 0; i < input.size(); i++) {

            Integer lowerBound = input.get(i).get(0);
            Integer upperBound = input.get(i).get(1);

            String concat = String.valueOf(lowerBound).concat(String.valueOf(upperBound));

            if (traversedSet.contains(concat)) {
                continue;
            }

            traversedSet.add(concat);

            for (int j = i + 1; j < input.size(); j++) {

                String first = String.valueOf(input.get(j).get(0));
                String second = String.valueOf(input.get(j).get(1));

                String key = first.concat(second);

                if (traversedSet.contains(key)) {
                    continue;
                }

                if (input.get(j).get(0) > upperBound) {
                    continue;
                }
                traversedSet.add(key);
                if (lowerBound > input.get(j).get(0)) {
                    lowerBound = input.get(j).get(0);
                }
                if (upperBound < input.get(j).get(1)) {
                    upperBound = input.get(j).get(1);
                }


            }
            nonOverlapping.add(Arrays.asList(lowerBound, upperBound));


        }

        return nonOverlapping;

    }

    public static void main(String[] args) {

        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(5);

        List<Integer> two = new ArrayList<>();
        two.add(5);
        two.add(10);

        List<Integer> three = new ArrayList<>();
        three.add(8);
        three.add(19);

        System.out.println(OverLappingArrays.mergeOverlappingIntervals(Arrays.asList(one, two, three)));
    }

}
