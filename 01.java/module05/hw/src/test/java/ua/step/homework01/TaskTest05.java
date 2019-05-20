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
public class TaskTest05 extends BaseTest {

    private final String expected;

    @Parameterized.Parameters(name = "seed = {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "1 - 3 раза\n" +
                        "-3 - 3 раза\n" +
                        "-5 - 2 раза"},
                {"1", "-1 - 2 раза\n" +
                        "1 - 2 раза\n" +
                        "3 - 2 раза"},
                {"2", "-4 - 2 раза\n" +
                        "4 - 2 раза"},
        });
    }

    public TaskTest05(String seed, String expected) {
        super(new String[]{seed}, Task05.class);
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.invokeMain(this.args);
        String errorMessage = "Ожидается " + expected;
        String actual = outContent.toString();
        assertEquals(errorMessage, expected, actual.trim());
    }
}