package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TaskTest06 extends BaseTest {

    private final String expected;

    @Parameterized.Parameters(name = "seed = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "0 -> 3 индекс\n" +
                        "3 -> 2 индекс"},
                {"1", "-2 -> 7 индекс\n" +
                        "-3 -> 5 индекс\n" +
                        "-4 -> 8 индекс\n" +
                        "4 -> 4 индекс"},
                {"2", "0 -> 9 индекс\n" +
                        "-1 -> 8 индекс\n" +
                        "-2 -> 7 индекс\n" +
                        "1 -> 6 индекс\n" +
                        "-3 -> 1 индекс\n" +
                        "3 -> 3 индекс"},
        });
    }

    public TaskTest06(String seed, String expected) {
        super(new String[]{seed}, Task06.class);
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.invokeMain(this.args);
        String errorMessage = "Ожидается " + expected;
        String actual = outContent.toString().trim().replaceAll("\\r", "");
        assertEquals(errorMessage, expected, actual.trim());
    }
}