package ua.step.homework01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

@RunWith(Parameterized.class)
public class TaskTest05 extends BaseTest {

    private final String number;
    private final String expected;

    public TaskTest05(String number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: isPalindrome({0})={1}")
    public static Collection<Object[]> weeks() {
        return Arrays.asList(new Object[][]{
                {"221122", "(yes|да|так)"},
                {"123321", "(yes|да|так)"},
                {"345543", "(yes|да|так)"},
                {"098890", "(yes|да|так)"},
                {"456654", "(yes|да|так)"},
                {"123324", "(no|нет|ні)"},
                {"123456", "(no|нет|ні)"},
                {"123213", "(no|нет|ні)"},
                {"978789", "(no|нет|ні)"},
                {"565656", "(no|нет|ні)"},
        });
    }

    @Test
    public void test() {
        System.setIn(new java.io.ByteArrayInputStream(number.getBytes()));
        Task05.main(null);
        String actual = outContent.toString().trim().toLowerCase();
        String errorMessage = String.format("Wrong result for number: %s. Expected: %s, Actual: %s", number, expected, actual);
        assertTrue(errorMessage, actual.matches(".*"+expected));
    }
}
