package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TaskTest12 extends BaseTest {

    private final String number;
    private final String expected;

    @Parameterized.Parameters(name="{index}: for x, y {0} day must be {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1 10", "25"},
                {"2 10", "17"},
                {"3 10", "13"},
                {"4 10", "10"},
                {"5 10", "8"},
                {"6 10", "6"},
                {"7 10", "4"},
                {"8 10", "3"},
                {"9 10", "2"},
                {"10 10", "0"},
        });
    }

    public TaskTest12(String number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Test
    public void test() {
        System.setIn(new java.io.ByteArrayInputStream(number.getBytes()));
        Task12.main(null);
        String actualResult = outContent.toString();
        int idx = actualResult.lastIndexOf(":");
        String actual = actualResult.substring(idx + 1).trim();
        String errorMessage = "for " + number + " day must be " + expected + " but actual " + actual;
        assertEquals(errorMessage, actual, expected);
    }
}
