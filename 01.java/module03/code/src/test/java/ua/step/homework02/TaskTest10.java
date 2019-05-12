package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest10 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", " ******\n" +
                      " **  **\n" +
                      " **  **\n" +
                      " **  **\n" +
                      " ******"},

                {"1", " ****\n" +
                      "   **\n" +
                      "   **\n" +
                      "   **\n" +
                      " ******"},

                {"2", " ******\n" +
                      "      *\n" +
                      " ******\n" +
                      " *     \n" +
                      " ******"},

                {"4", " **  **\n" +
                      " **  **\n" +
                      " ******\n" +
                      "     **\n" +
                      "     **"},

                {"7", " ******\n" +
                      "     **\n" +
                      "     **\n" +
                      "     **\n" +
                      "     **"},

                {"8", " ******\n" +
                      " **  **\n" +
                      " ******\n" +
                      " **  **\n" +
                      " ******"},

                {"9", " ******\n" +
                      " **  **\n" +
                      " ******\n" +
                      "     **\n" +
                      " ******"},
                {"100", "****  \n" +
                        "  **  \n" +
                        "  **  \n" +
                        "  **  \n" +
                        "******\n" +
                        "******\n" +
                        "**  **\n" +
                        "**  **\n" +
                        "**  **\n" +
                        "******\n" +
                        "******\n" +
                        "**  **\n" +
                        "**  **\n" +
                        "**  **\n" +
                        "******"},

                {"4107", "**  **\n" +
                         "**  **\n" +
                         "******\n" +
                         "    **\n" +
                         "    **\n" +
                         "****  \n" +
                         "  **  \n" +
                         "  **  \n" +
                         "  **  \n" +
                         "******\n" +
                         "******\n" +
                         "**  **\n" +
                         "**  **\n" +
                         "**  **\n" +
                         "******\n" +
                         "******\n" +
                         "    **\n" +
                         "    **\n" +
                         "    **\n" +
                         "    **"},
               });
    }

    private final String input;
    private final String expected;

    public TaskTest10(String input, String expected) {
        super(null, Task10.class);
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong draw number: %s", input);
        super.systemInputTest(input, expected, errorMessage);
    }
}
