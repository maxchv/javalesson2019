package ua.step.homework01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.step.homework1.Task01;

public class TestTask01 {
    @Test
    @DisplayName("Test createOneMethod 2x2")
    public void testCreateOne2x2() {
        int[][] actual = Task01.createOne(2,2);
        int[][] expected = { {1,0}, {0,1}};
        Assertions.assertArrayEquals(expected[0], actual[0]);
        Assertions.assertArrayEquals(expected[1], actual[1]);
    }

    @Test
    @DisplayName("Test createOneMethod 3x3")
    public void testCreateOne3x3() {
        int[][] actual = Task01.createOne(3,3);
        int[][] expected = { {0,1,0}, {0,1,0}, {0,0,1}};
        Assertions.assertArrayEquals(expected[0], actual[0]);
        Assertions.assertArrayEquals(expected[1], actual[1]);
        Assertions.assertArrayEquals(expected[2], actual[2]);
    }
}
