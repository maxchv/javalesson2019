package org.itstep;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestQuickSort {

    @Test
    void test1() {
        int[] input = {9, 2, 8, 1, 5, 6, 7, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actual = App.quickSort(input);
        Assertions.assertArrayEquals(expected, actual);
    }
}
