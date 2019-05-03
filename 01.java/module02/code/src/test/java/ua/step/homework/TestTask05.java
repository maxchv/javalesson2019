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
public class TestTask05 extends BaseTest {

    private final String input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5 12 1974", "знак: стрелец год: тигра"},
                {"21 5 1981", "знак: близнецы год: петуха"},
                {"22 3 2008", "знак: овен год: крысы"},
                {"20 5 1985", "знак: телец год: быка"},
                {"21 7 1999", "знак: рак год: кролика"},
                {"21 8 1964", "знак: лев год: дракона"},
                {"24 9 1989", "знак: весы год: змеи"},
                {"18 12 2002", "знак: стрелец год: лошади"},
                {"19 1 2015", "знак: козерог год: козы"},
                {"16 2 2016", "знак: водолей год: обезьяны"},
                {"12 3 1995", "знак: рыбы год: свиньи"},
            }
        );
    }

    public TestTask05(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.input.getBytes()));
    }

    @Test
    public void test() {
        Task05.main(null);
        String out = outContent.toString();
        int idx = out.indexOf(":");
        Assert.assertEquals(this.expected, out.substring(idx+1).toLowerCase().replaceAll("\\s+", " ").trim());
    }
}
