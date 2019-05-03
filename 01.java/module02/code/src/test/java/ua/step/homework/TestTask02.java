package ua.step.homework;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTask02 extends BaseTest {

    private final String hour;
    private final String message;

    @Parameterized.Parameters
    public static Collection<Object[]> weeks() {
        return Arrays.asList(new Object[][]{
                {"0", "доброй ночи"},
                {"1", "доброй ночи"},
                {"2", "доброй ночи"},
                {"3", "доброй ночи"},
                {"4", "доброй ночи"},
                {"5", "доброй ночи"},
                {"6", "доброе утро"},
                {"7", "доброе утро"},
                {"8", "доброе утро"},
                {"9", "доброе утро"},
                {"10", "доброе утро"},
                {"11", "доброе утро"},
                {"12", "добрый день"},
                {"13", "добрый день"},
                {"14", "добрый день"},
                {"15", "добрый день"},
                {"16", "добрый день"},
                {"17", "добрый день"},
                {"18", "добрый вечер"},
                {"19", "добрый вечер"},
                {"20", "добрый вечер"},
                {"21", "добрый вечер"},
                {"22", "добрый вечер"},
                {"23", "добрый вечер"},
                {"-1", "некорректный ввод"},
                {"24", "некорректный ввод"},
                {"25", "некорректный ввод"},
        });
    }

    public TestTask02(String hour, String message) {
        this.hour = hour;
        this.message = message;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.hour.getBytes()));
    }

    @Test
    public void test() {
        Task02.main(null);
        String out = outContent.toString();
        int idx = out.indexOf(":");
        assertEquals(message, out.substring(idx+1).toLowerCase().trim());
    }
}