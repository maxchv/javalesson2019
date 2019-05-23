package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest12 extends BaseTest {

    private final String expected;
    private final String input;

    @Parameterized.Parameters(name = "input = {0}, result = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2 2 1 1 2 1", "no"},
                {"2 2 1 1 2 2", "yes"},
                {"2 2 1 3 2 2", "no"},
                {"3 2 1 3 2 2 1 2 1 2 3", "no"},
                {"3 3 1 3 1 2 1 2 3 2 3", "yes"},
        });
    }

    public TaskTest12(String input, String expected) {
        super(null, Task12.class);
        this.expected = expected;
        this.input = input;
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(testClass == null) return;
        String errorMessage = String.format("Ожидается, что для массива %s вывод должен быть %s", input, expected);
        super.systemInputTest(input, expected, errorMessage);
    }
}