package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class TaskTest02 extends BaseTest {

    private final String expected;

    public TaskTest02() {
        super(new String[]{"0"}, Task02.class);
        this.expected = "-68 57";
    }

    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.invokeMain(this.args);
        String errorMessage = "Ожидается " + expected;
        String actual = outContent.toString();
        assertEquals(errorMessage, expected, actual.trim());
    }
}