package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class TaskTest01 extends BaseTest {

    private final String expected;

    public TaskTest01() {
        super(null, Task01.class);
        this.expected = "1 2 5 13 34 89 233 610";
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.invokeMain(this.args);
        String errorMessage = "Ожидается " + expected;
        String actual = outContent.toString();
        assertEquals(errorMessage, expected, actual.trim());
    }
}