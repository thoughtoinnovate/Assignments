package org.assignments.problems;

import java.util.HashMap;
import java.util.Map;

/***
 * You have an ice-cream parlor and sell one ice-cream for $5 and currency notes available in that country is of $5,10,20
 * If there is fixed queue outside the shop , you want to make sure that you can fulfil all requests by providing change.
 * Initially you don't have any balance.
 *
 * e.g. people in queue with currency
 * (5,10,5,10)=true(we can satisfy teh change till end customer)
 * (10,5,5)=false (we can't satisfy as we dont have any balance first to return $5 change)
 * (5,5,5,20)=true
 */
public class CurrencyChangeShop {


    public static boolean isExchangePossible(Integer[] peopleCurrencyQueue) {

        if (null == peopleCurrencyQueue || peopleCurrencyQueue[0] != 5) {
            return false;
        }

        Map<Integer, Integer> wallet = new HashMap<>();

        for (int curr : peopleCurrencyQueue) {

            if (wallet.containsKey(curr)) {
                wallet.put(curr, wallet.get(curr) + 1);
            } else {
                wallet.put(curr, 1);
            }

            if (curr > 5) {
                //check wallet
                int amountToReturn = curr - 5;

                if (wallet.containsKey(amountToReturn) && wallet.get(amountToReturn) > 0) {
                    wallet.put(amountToReturn, wallet.get(amountToReturn) - 1);
                    continue;
                } else {
                    //remaining amount doesn't have exact currency
                    //check other currencies starting with biggest

                    if (amountToReturn % 20 == 0 && wallet.get(20) >= (amountToReturn / 20)) {
                        wallet.put(20, wallet.get(20) - (amountToReturn / 20));
                        continue;
                    } else if (amountToReturn % 10 == 0 && wallet.get(10) >= (amountToReturn / 10)) {
                        wallet.put(10, wallet.get(10) - (amountToReturn / 10));
                        continue;
                    } else if (amountToReturn % 5 == 0 && wallet.get(5) >= (amountToReturn / 5)) {
                        wallet.put(5, wallet.get(5) - (amountToReturn / 5));
                        continue;
                    }


                }


            } else {
                continue;
            }

            return false;

        }

        return true;

    }

}
