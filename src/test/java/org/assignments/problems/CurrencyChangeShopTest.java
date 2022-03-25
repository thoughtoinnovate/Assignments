package org.assignments.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrencyChangeShopTest {

    @Test
    void isExchangePossible() {
        Assertions.assertTrue(CurrencyChangeShop.isExchangePossible(new Integer[]{5, 10, 5, 10}));
        Assertions.assertFalse(CurrencyChangeShop.isExchangePossible(new Integer[]{10, 5, 5}));
        Assertions.assertTrue(CurrencyChangeShop.isExchangePossible(new Integer[]{5, 5, 5, 20}));
        Assertions.assertTrue(CurrencyChangeShop.isExchangePossible(new Integer[]{5, 5, 5, 20, 5, 10}));
        Assertions.assertFalse(CurrencyChangeShop.isExchangePossible(new Integer[]{5, 5, 5, 20, 5, 10, 10}));
    }
}