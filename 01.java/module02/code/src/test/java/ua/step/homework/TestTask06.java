package ua.step.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask06 extends BaseTest {

    private final String input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"2", "365"},
                        {"3", "365"},
                        {"4", "366"},
                        {"5", "365"},
                        {"8", "366"},
                        {"9", "365"},
                        {"12", "366"},
                        {"13", "365"},
                        {"100", "366"},
                        {"101", "365"},
                        {"200", "366"},
                        {"201", "365"},
                        {"400", "366"},
                        {"401", "365"},
                        {"404", "366"},
                        {"1000", "366"},
                        {"1001", "365"},
                        {"1012", "366"},
                        {"1015", "365"},
                        {"1480", "366"},
                        {"1548", "366"},
                        {"1549", "365"},
                        {"2000", "366"},
                        {"2001", "365"},
                        {"2004", "366"},
                        {"2005", "365"},
                        {"2008", "366"},
                        {"2015", "365"},
                        {"2016", "366"},
                        {"2019", "365"},
                        {"2020", "366"},
                }
        );
    }

    public TestTask06(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.input.getBytes()));
    }

    @Test
    public void test() {
        Task06.main(null);
        String out = outContent.toString();
        int idx = out.indexOf(":");
        Assert.assertEquals(this.expected, out.substring(idx + 1).toLowerCase().trim());
    }
}
