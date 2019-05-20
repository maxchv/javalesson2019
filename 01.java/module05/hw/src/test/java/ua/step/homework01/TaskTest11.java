package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest11 extends BaseTest {

    private final String expected;
    private final String size;

    @Parameterized.Parameters(name = "seed = {0}, size = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "10 3", "исходный массив [67, 72, 93, 5, 9, 54, 82, 42, 84, 98]\n" +
                        "результат\n" +
                        "[67, 72, 93]\n" +
                        "[5, 9, 54]\n" +
                        "[82, 42, 84]\n" +
                        "[98]"},
                {"1", "10 5", "исходный массив [97, 5, 21, 41, 77, 60, 33, 30, 45, 50]\n" +
                        "результат\n" +
                        "[97, 5, 21, 41, 77]\n" +
                        "[60, 33, 30, 45, 50]"},
                {"1", "10 9", "исходный массив [97, 5, 21, 41, 77, 60, 33, 30, 45, 50]\n" +
                        "результат\n" +
                        "[97, 5, 21, 41, 77, 60, 33, 30, 45]\n" +
                        "[50]"},
                {"2", "15 3", "исходный массив [5, 37, 68, 0, 41, 41, 80, 100, 93, 95, 41, 63, 92, 1, 32]\n" +
                        "результат\n" +
                        "[5, 37, 68]\n" +
                        "[0, 41, 41]\n" +
                        "[80, 100, 93]\n" +
                        "[95, 41, 63]\n" +
                        "[92, 1, 32]"},
                {"3", "3 3", "исходный массив [36, 4, 63]\n" +
                        "результат\n" +
                        "[36, 4, 63]"},
                {"3", "3 1", "исходный массив [36, 4, 63]\n" +
                        "результат\n" +
                        "[36]\n" +
                        "[4]\n" +
                        "[63]"},

        });
    }

    public TaskTest11(String seed, String size, String expected) {
        super(new String[]{seed}, Task11.class);
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