package ua.step.homework01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.step.homework1.Task01;

import java.util.stream.Stream;

class TestTask01 {
    private static class Size {
        int columns;
        int rows;

        Size(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
        }

        int getColumns() {
            return columns;
        }

        int getRows() {
            return rows;
        }
    }
    private static Stream<Arguments> sourceForCreateOne() {
        return Stream.of(
                    Arguments.of(new Size(2, 2), new int[][]{{1, 0}, {0, 1}}),
                    Arguments.of(new Size(3, 3), new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})
                );
    }

    @ParameterizedTest
    @DisplayName("Test createOneMethod")
    @MethodSource("sourceForCreateOne")
    void testCreateOne(Size size, int[][] expected) {
        int[][] actual = Task01.createOne(size.getRows(), size.getColumns());
        Assertions.assertArrayEquals(expected[0], actual[0]);
        Assertions.assertArrayEquals(expected[1], actual[1]);
    }
}
