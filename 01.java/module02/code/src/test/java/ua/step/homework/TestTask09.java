package ua.step.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask09 extends BaseTest {

    private final String[] input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new String[]{"0", "0", "5", "5"}, "подъем"},
                        {new String[]{"1", "1", "2", "2"}, "подъем"},
                        {new String[]{"-2", "-4", "1", "-1"}, "подъем"},
                        {new String[]{"1", "1", "2", "1"}, "ровно"},
                        {new String[]{"1", "2", "2", "1"}, "спуск"},
                        {new String[]{"-5", "5", "3", "-3"}, "спуск"},
                }
        );
    }

    public TestTask09(String[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws IOException {
        Task09.main(input);
        String actual = outContent.toString().trim().toLowerCase();
        Assert.assertEquals(this.expected, actual);
    }
}
