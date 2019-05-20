package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest10 extends BaseTest {

    private final String expected;
    private final String size;

    @Parameterized.Parameters(name = "seed = {0}, size = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "10", "исходный массив [18, 28, 3, 19, 13, 33, 19, 3, 1, 0]\n" +
                            "индекс элемента -1"},
                {"1", "15", "исходный массив [15, 10, 27, 33, 30, 22, 10, 6, 8, 30, 23, 31, 29, 27, 26]\n" +
                        "индекс элемента -1"},
                {"2", "20", "исходный массив [22, 12, 14, 33, 21, 20, 4, 23, 11, 10, 16, 4, 2, 26, 32, 12, 3, 33, 32, 19]\n" +
                        "индекс элемента -1"},
                {"5", "20", "исходный массив [5, 16, 32, 12, 14, 31, 0, 1, 22, 11, 27, 13, 21, 0, 28, 30, 2, 9, 31, 15]\n" +
                        "индекс элемента 8"},

        });
    }

    public TaskTest10(String seed, String size, String expected) {
        super(new String[]{seed}, Task10.class);
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