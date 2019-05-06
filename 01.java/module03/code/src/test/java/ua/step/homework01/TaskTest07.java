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
public class TaskTest07 extends BaseTest {

    private final String number;
    private final String expected;

    @Parameterized.Parameters(name="{index}: {0} must be {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1", "1"},
                {"2", "10"},
                {"3", "11"},
                {"4", "100"},
                {"5", "101"},
                {"6", "110"},
                {"7", "111"},
                {"8", "1000"},
                {"9", "1001"},
                {"10", "1010"},
        });
    }

    public TaskTest07(String number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Test
    public void test() {
        System.setIn(new java.io.ByteArrayInputStream(number.getBytes()));
        Task07.main(null);
        String actualResult = outContent.toString();
        int idx = actualResult.indexOf(":");
        String actual = actualResult.substring(idx + 1).trim();
        String errorMessage = "for " + number + " name must be " + expected + " actual " + actual;
        assertEquals(errorMessage, actual, expected);
    }
}
