package org.itstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecursionTest {

    @Test
    void testPalindrome() {
        boolean actual = Recursion.isPalindromeByRecursion("ABBA");
        //boolean expected = true;
        Assertions.assertTrue(actual, "Это же палиндром!!!");
        /*if(actual != expected) {
            throw new RuntimeException("Error");
        }*/
    }

}
