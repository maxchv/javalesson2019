package org.itstep;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListExtTest {

    ListExt<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayListExt<>();
        list.addAll(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void filter() {
        ListExt<Integer> filtered = list.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(5, filtered.size());
        assertArrayEquals(new Integer[]{0, 2, 4, 6, 8}, filtered.toArray(new Integer[0]));
    }

    @Test
    void map() {
        ListExt<String> converted = list.convert(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(10, converted.size());
        assertArrayEquals(new String[]{"0","1","2","3","4","5","6","7","8","9"},
                converted.toArray(new String[0]));
    }

    @Test
    void takeWhile() {
        ListExt<Integer> takeWile = list.takeWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer <= 3;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(4, takeWile.size());
        assertArrayEquals(new Integer[]{0, 1, 2, 3}, takeWile.toArray(new Integer[0]));
    }

    @Test
    void dropWhile() {
        ListExt<Integer> dropWile = list.takeWhile(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer <= 3;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(6, dropWile.size());
        assertArrayEquals(new Integer[]{4, 5, 6, 7, 8, 9}, dropWile.toArray(new Integer[0]));
    }

    @Test
    void reduce() {
        int summ = list.reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(45, summ);
    }

    @Test
    void max() {
        int max = list.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(9, max);
    }

    @Test
    void min() {
        int min = list.min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertEquals(0, min);
    }

    @Test
    void anyMatch() {
        boolean anyMatch = list.anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 10;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertTrue(anyMatch);
    }

    @Test
    void allMatch() {
        boolean allMatch = list.anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 10;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertFalse(allMatch);
    }

    @Test
    void noneMatch() {
        boolean noneMatch = list.anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        });
        assertEquals(10, list.size(), "Исходный массив не должен меняться");
        assertTrue(noneMatch);
    }
}