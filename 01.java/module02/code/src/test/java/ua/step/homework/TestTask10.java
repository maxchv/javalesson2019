package ua.step.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask10 extends BaseTest {

    private final String[] input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new String[]{"1", "4"}, "1"},
                        {new String[]{"10", "4"}, "1"},
                        {new String[]{"35", "4"}, "1"},
                        {new String[]{"36", "4"}, "1"},
                        {new String[]{"37", "4"}, "2"},
                        {new String[]{"37", "6"}, "1"},
                        {new String[]{"50", "4"}, "2"},
                        {new String[]{"127", "20"}, "1"},
                        {new String[]{"127", "4"}, "4"},
                }
        );
    }

    public TestTask10(String[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws IOException {
        Task10.main(input);
        String actual = outContent.toString().trim().toLowerCase();
        Assert.assertEquals(this.expected, actual);
    }
}
