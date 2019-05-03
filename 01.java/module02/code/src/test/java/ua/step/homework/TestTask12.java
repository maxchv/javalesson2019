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
public class TestTask12 extends BaseTest {

    private final String input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"123456", "нет"},
                {"123123", "да"},
                {"123321", "да"},
                {"123322", "нет"},
                {"456456", "да"},
            }
        );
    }

    public TestTask12(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.input.getBytes()));
    }

    @Test
    public void test() throws IOException {
        Task12.main(null);
        String out = outContent.toString();
        int idx = out.indexOf(":");
        Assert.assertEquals(this.expected, out.substring(idx+1).toLowerCase().replaceAll("\\s+", " ").trim());
    }
}
