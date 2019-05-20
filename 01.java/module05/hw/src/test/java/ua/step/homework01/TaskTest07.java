package ua.step.homework01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TaskTest07 extends BaseTest {

    private final String expected;
    private final String size;

    @Parameterized.Parameters(name = "seed = {0}, size = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "10", "3 - 2 раза\n" +
                        "5 - 3 раза\n" +
                        "8 - 1 раза\n" +
                        "9 - 3 раза\n" +
                        "11 - 1 раза"},
                {"0", "15", "3 - 2 раза\n" +
                        "5 - 7 раза\n" +
                        "8 - 2 раза\n" +
                        "9 - 3 раза\n" +
                        "11 - 1 раза"},
                {"1", "10", "3 - 2 раза\n" +
                        "5 - 3 раза\n" +
                        "8 - 1 раза\n" +
                        "9 - 3 раза\n" +
                        "11 - 1 раза"},
                {"2", "10", "3 - 2 раза\n" +
                        "5 - 3 раза\n" +
                        "8 - 1 раза\n" +
                        "9 - 3 раза\n" +
                        "11 - 1 раза"},
        });
    }

    public TaskTest07(String seed, String size, String expected) {
        super(new String[]{seed}, Task07.class);
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