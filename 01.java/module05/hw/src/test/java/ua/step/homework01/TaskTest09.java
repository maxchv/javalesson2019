package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest09 extends BaseTest {

    private final String expected;
    private final String size;

    @Parameterized.Parameters(name = "seed = {0}, size = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "10", "Исходный массив [3, 3, 8, 6, -2, 7, 5, 0, 1, 1]\n" +
                        "Результат [3, 3, 8, 6, 4, 7, 5, 0, 1, 1]"},
                {"1", "10", "исходный массив [2, -2, 5, 7, 10, 9, 5, 7, 7, 8]\n" +
                        "результат [2, 4, 5, 7, 10, 9, 5, 7, 7, 8]"},
                {"2", "10", "исходный массив [3, 4, -2, 6, 2, 2, 6, 10, -2, 2]\n" +
                        "результат [3, 4, 4, 6, 2, 2, 6, 10, 4, 2]"},
                {"0", "20", "исходный массив [6, 7, 20, 11, 8, 20, 10, 3, 3, 13, 15, 15, 15, 2, 18, 6, 10, -2, 5, -1]\n" +
                        "результат [6, 7, 20, 11, 8, 20, 10, 3, 3, 13, 15, 15, 15, 2, 18, 6, 10, 4, 5, 1]"},

        });
    }

    public TaskTest09(String seed, String size, String expected) {
        super(new String[]{seed}, Task09.class);
        this.expected = expected;
        this.size = size;
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(testClass == null) return;
        String errorMessage = String.format("Ожидается, что для массива размером %s вывод будет %s", size, expected);
        super.systemInputTest(size, expected, errorMessage);
    }
}