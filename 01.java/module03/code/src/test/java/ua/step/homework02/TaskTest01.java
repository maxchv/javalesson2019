package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TaskTest01 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3", "  *\n **\n***"},
                {"4", "   *\n  **\n ***\n****"},
                {"5", "    *\n   **\n  ***\n ****\n*****"},
                {"6", "     *\n    **\n   ***\n  ****\n *****\n******"},
                {"7", "      *\n     **\n    ***\n   ****\n  *****\n ******\n*******"},
                {"8", "       *\n      **\n     ***\n    ****\n   *****\n  ******\n *******\n********"},
                {"9", "        *\n       **\n      ***\n     ****\n    *****\n   ******\n  *******\n ********\n*********"},
        });
    }

    private final String number;
    private final String expected;

    public TaskTest01(String number, String expected) {
        super(null, Task01.class);
        this.number = number;
        this.expected = expected;
    }


    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong full triangle for height: %s", number);
        super.systemInputTest(number, expected, errorMessage);
    }
}
