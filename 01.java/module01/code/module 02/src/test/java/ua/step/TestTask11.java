package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task11;

public class TestTask11
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void test1()
    {
        Task11.main(new String[] { "1" });
        assertEquals("0 дней, 0 часов, 0 минут и 1 секунд", outContent.toString());
    }

    @Test
    public void test2()
    {
        Task11.main(new String[] { "61" });
        assertEquals("0 дней, 0 часов, 1 минут и 1 секунд", outContent.toString());
    }

    @Test
    public void test3()
    {
        Task11.main(new String[] { "914733" });
        assertEquals("10 дней, 14 часов, 5 минут и 33 секунд", outContent.toString());
    }
}
