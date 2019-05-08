package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TaskTest04 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                 {"3"," *\n" +
                      "***\n" +
                      " *"},
                 {"4","  *\n" +
                      " ***\n" +
                      "*****\n" +
                      " ***\n" +
                      "  *"},
                 {"5","  *\n" +
                      " ***\n" +
                      "*****\n" +
                      " ***\n" +
                      "  *"},
                 {"6","   *\n" +
                      "  ***\n" +
                      " *****\n" +
                      "*******\n" +
                      " *****\n" +
                      "  ***\n" +
                      "   *"},
                 {"7","   *\n" +
                      "  ***\n" +
                      " *****\n" +
                      "*******\n" +
                      " *****\n" +
                      "  ***\n" +
                      "   *"},
                 {"8","    *\n" +
                      "   ***\n" +
                      "  *****\n" +
                      " *******\n" +
                      "*********\n" +
                      " *******\n" +
                      "  *****\n" +
                      "   ***\n" +
                      "    *"},
                 {"9","    *\n" +
                      "   ***\n" +
                      "  *****\n" +
                      " *******\n" +
                      "*********\n" +
                      " *******\n" +
                      "  *****\n" +
                      "   ***\n" +
                      "    *"},
               });
    }

    private final String number;
    private final String expected;

    public TaskTest04(String number, String expected) {
        super(null, Task04.class);
        this.number = number;
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong result for height: %s", number);
        super.systemInputTest(number, expected, errorMessage);
    }
}
