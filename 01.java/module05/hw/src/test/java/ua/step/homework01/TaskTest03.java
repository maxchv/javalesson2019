package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class TaskTest03 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                 {"1\n1","yes"},
                 {"2\n2 3","no"},
                 {"2\n3 3","yes"},
                 {"3\n1 2 3","no"},
                 {"3\n1 1 1","yes"},
                 {"3\n2 2 3","no"},
                 {"3\n3 3 3","yes"},
                 {"4\n33 33 33 33","yes"},
                 {"5\n2 2 2 2 2","yes"},
                 {"3\n3 3 3","yes"},
                 {"10\n1 2 3 4 5 6 7 8 9 10","no"},
                 {"10\n9 9 9 9 9 9 9 9 9 9","yes"},
               });
    }

    private final String input;
    private final String expected;

    public TaskTest03(String input, String expected) {
        super(null, Task03.class);
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(testClass == null) return;
        String errorMessage = String.format("Ожидается, что для массива %s результат будет %s", input, expected);
        super.systemInputTest(input, expected, errorMessage);
    }
}
