package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest08 extends BaseTest {

    private final String expected;
    private final String size;

    @Parameterized.Parameters(name = "seed = {0}, size = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "60", "g - 4 раза\n" +
                        "l - 4 раза\n" +
                        "s - 5 раз\n" +
                        "v - 5 раз\n" +
                        "x - 5 раз"},
                {"1", "60", "e - 5 раз\n" +
                        "m - 8 раз\n" +
                        "p - 5 раз\n" +
                        "r - 4 раза\n" +
                        "w - 4 раза"},
                {"2", "60", "e - 4 раза\n" +
                        "g - 4 раза\n" +
                        "k - 4 раза\n" +
                        "p - 4 раза\n" +
                        "r - 4 раза\n" +
                        "y - 5 раз"},
                {"0", "300", "a - 13 раз\n" +
                        "b - 10 раз\n" +
                        "c - 13 раз\n" +
                        "d - 9 раз\n" +
                        "e - 11 раз\n" +
                        "f - 8 раз\n" +
                        "g - 13 раз\n" +
                        "h - 16 раз\n" +
                        "i - 6 раз\n" +
                        "j - 13 раз\n" +
                        "k - 9 раз\n" +
                        "l - 15 раз\n" +
                        "m - 11 раз\n" +
                        "n - 7 раз\n" +
                        "o - 18 раз\n" +
                        "p - 13 раз\n" +
                        "q - 14 раз\n" +
                        "r - 16 раз\n" +
                        "s - 16 раз\n" +
                        "t - 5 раз\n" +
                        "u - 5 раз\n" +
                        "v - 10 раз\n" +
                        "w - 11 раз\n" +
                        "x - 20 раз\n" +
                        "y - 8 раз\n" +
                        "z - 10 раз"},
        });
    }

    public TaskTest08(String seed, String size, String expected) {
        super(new String[]{seed}, Task08.class);
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