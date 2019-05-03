package ua.step.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask08 extends BaseTest {

    private final String[] input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new String[]{"4", "2"}, "yes"},
                        {new String[]{"40", "20"}, "yes"},
                        {new String[]{"482", "9282"}, "yes"},
                        {new String[]{"632", "990"}, "yes"},
                        {new String[]{"632", "1002"}, "yes"},
                        {new String[]{"3", "7"}, "no"},
                        {new String[]{"13", "73"}, "no"},
                        {new String[]{"31", "79"}, "no"},
                        {new String[]{"33", "53"}, "no"},
                        {new String[]{"4", "3"}, ""},
                        {new String[]{"5", "6"}, ""},
                        {new String[]{"41", "4"}, ""},
                        {new String[]{"42", "3"}, ""},
                        {new String[]{"101", "202"}, ""},
                }
        );
    }

    public TestTask08(String[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        Task08.main(input);
        String actual = outContent.toString().trim().toLowerCase();
        Assert.assertEquals(this.expected, actual);
    }
}
