package org.assignments;

import org.assignments.problems.CustomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringUtilsTest {

    private CustomStringUtils customStringUtils;

    @BeforeEach
    public void setup() {
        customStringUtils = new CustomStringUtils();
    }

    @Test
    void findStringsWithCapitals() {

        //Empty Array string as input
        Assertions.assertThrows(IllegalArgumentException.class, () -> customStringUtils.findStringsWithCapitals(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> customStringUtils.findStringsWithCapitals(new String[]{}));

        //contains one string with capitals
        String[] testString = {"hello", "Test", "random"};
        Assertions.assertTrue(!customStringUtils.findStringsWithCapitals(testString).isEmpty());
        Assertions.assertTrue(customStringUtils.findStringsWithCapitals(testString).size() == 1);
        Assertions.assertTrue(customStringUtils.findStringsWithCapitals(testString).get(0) == "Test");

        //contains more than one case
        testString[0] = "This";
        Assertions.assertTrue(customStringUtils.findStringsWithCapitals(testString).size() == 2);

        //no strings having the case
        Assertions.assertTrue(customStringUtils.findStringsWithCapitals(new String[]{"hi", "sample", "r@ndo$"}).isEmpty());

    }

    @Test
    void findCapitalStringsUsingRegex() {

        {

            //Empty Array string as input
            Assertions.assertThrows(IllegalArgumentException.class, () -> customStringUtils.findCapitalStringsUsingRegex(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> customStringUtils.findCapitalStringsUsingRegex(new String[]{}));

            //contains one string with capitals
            String[] testString = {"hello", "Test", "random"};
            Assertions.assertTrue(!customStringUtils.findCapitalStringsUsingRegex(testString).isEmpty());
            Assertions.assertTrue(customStringUtils.findCapitalStringsUsingRegex(testString).size() == 1);
            Assertions.assertTrue(customStringUtils.findCapitalStringsUsingRegex(testString).get(0) == "Test");

            //contains more than one case
            testString[0] = "This";
            Assertions.assertTrue(customStringUtils.findCapitalStringsUsingRegex(testString).size() == 2);

            //no strings having the case
            Assertions.assertTrue(customStringUtils.findCapitalStringsUsingRegex(new String[]{"hi", "sample", "r@ndo$"}) == null);

        }
    }
}