package ua.step.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask11 extends BaseTest {

    private final String[] input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new String[]{"1", "2", "3"}, "уравнение не имеет действительных решений"},
                        {new String[]{"3", "2", "3"}, "уравнение не имеет действительных решений"},
                        {new String[]{"5", "2", "3"}, "уравнение не имеет действительных решений"},
                        {new String[]{"5", "12", "1"}, "x1 = -2.314, x2 = -0.086"},
                        {new String[]{"4", "21", "5"}, "x1 = -5.000, x2 = -0.250"},
                        {new String[]{"-3", "5", "5"}, "x1 = 2.370, x2 = -0.703"},
                }
        );
    }

    public TestTask11(String[] input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws IOException {
        Task11.main(input);
        String actual = outContent.toString().split("\\n")[1].trim().toLowerCase();
        Assert.assertEquals(this.expected, actual);
    }
}
