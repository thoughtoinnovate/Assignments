package org.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Convenience class having utilities for string operations.
 */
public class CustomStringUtils {

    /***
     * This convenience method finds a string which has at least one capital letter in it.
     * Complexity: O(N2)
     * @param stringArray
     * @return list of the strings.
     */
    public List<String> findStringsWithCapitals(String[] stringArray) {

        if (null == stringArray || stringArray.length < 1) {
            throw new IllegalArgumentException("Provided string array empty.");
        }

        List<String> result = new ArrayList<>();

        for (String word : stringArray) {

            for (char letter : word.toCharArray()) {

                if (Character.isUpperCase(letter)) {
                    result.add(word);
                }
            }
        }

        return result;
    }

    /***
     * This convenience method finds a string which has at least one capital letter in it, Using Regex Pattern.
     * @param stringArray
     * @return list of the strings.
     */
    public List<String> findCapitalStringsUsingRegex(String[] stringArray) {

        if (null == stringArray || stringArray.length < 1) {
            throw new IllegalArgumentException("Provided string array empty.");
        }

        Pattern containsUpperCasePattern = Pattern.compile(".*[A-Z].*");
        List<String> result = null;

        for (String word : stringArray) {

            if (containsUpperCasePattern.matcher(word).matches()) {

                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(word);
            }
        }

        return result;
    }
}
