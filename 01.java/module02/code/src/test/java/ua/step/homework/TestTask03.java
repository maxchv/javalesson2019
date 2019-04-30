package ua.step.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask03 extends BaseTest {

    private final String[] array_in;
    private final String[] expected_out;

    @Parameterized.Parameters
    public static Collection<Object[]> weeks() {
        return Arrays.asList(new Object[][]{
            {new String[]{}, new String[]{"4", "5", "7"}},
            {new String[]{"1", "2", "3"}, new String[]{"1", "2", "3"}},
            {new String[]{"2", "1", "3"}, new String[]{"1", "2", "3"}},
            {new String[]{"3", "1", "2"}, new String[]{"1", "2", "3"}},
            {new String[]{"3", "2", "1"}, new String[]{"1", "2", "3"}},
        });
    }

    public TestTask03(String[] array_in, String[] expected_out) {
        this.array_in = array_in;
        this.expected_out = expected_out;
    }

    @Test
    public void test() {
        Task03.main(array_in);
        String[] result = outContent.toString().split("\\s+");
        Assert.assertArrayEquals(expected_out, result);
    }
}
