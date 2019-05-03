package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task10;

public class TestTask10
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
        Task10.main(new String[] { "198", "95" });
        assertEquals("-7", outContent.toString().trim());
    }

    @Test
    public void test2()
    {
        Task10.main(new String[] { "158", "34" });
        assertEquals("14", outContent.toString().trim());
    }

    @Test
    public void test3()
    {
        Task10.main(new String[] { "170", "60" });
        assertEquals("0", outContent.toString().trim());
    }
}
