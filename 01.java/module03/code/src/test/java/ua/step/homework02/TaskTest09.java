package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest09 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3 1", "    *\n" +
                        "   ***\n" +
                        "  *****"},

                {"3 2", "    *\n" +
                        "   ***\n" +
                        "  *****" +
                        "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******"},

                {"3 3", "    *\n" +
                        "   ***\n" +
                        "  *****" +
                        "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******" +
                        "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******\n" +
                        "*********"},

                {"4 1", "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******"},

                {"4 2", "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******\n" +
                        "    *\n" +
                        "   ***\n" +
                        "  *****\n" +
                        " *******\n" +
                        "*********"},
               });
    }

    private final String input;
    private final String expected;

    public TaskTest09(String input, String expected) {
        super(null, Task09.class);
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong draw spruce for size: %s", input);
        super.systemInputTest(input, expected, errorMessage);
    }
}
