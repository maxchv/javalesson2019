package org.itstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void testIsNumberException() {
        Assertions.assertThrows(RuntimeException.class,
                NumberTest::testThrowException);
    }

    private static void testThrowException() {
        App.isNumber("test");
    }

}
