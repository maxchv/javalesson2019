package ua.step.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask04 extends BaseTest {

    private final String[] array_in;
    private final String expected_out;

    @Parameterized.Parameters
    public static Collection<Object[]> weeks() {
        return Arrays.asList(new Object[][]{
                {new String[]{}, "I"},
                {new String[]{"1", "11"}, "I"},
                {new String[]{"1100", "100"}, "I"},
                {new String[]{"-2", "3"}, "II"},
                {new String[]{"-1021", "19593"}, "II"},
                {new String[]{"-2", "-3"}, "III"},
                {new String[]{"-7475782", "-399504"}, "III"},
                {new String[]{"2", "-3"}, "IV"},
                {new String[]{"25849", "-33049"}, "IV"},
        });
    }

    public TestTask04(String[] array_in, String expected_out) {
        this.array_in = array_in;
        this.expected_out = expected_out;
    }

    @Test
    public void test() {
        Task04.main(array_in);
        Assert.assertEquals(expected_out, outContent.toString().trim());
    }
}
