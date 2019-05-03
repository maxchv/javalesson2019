package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task05;
import ua.step.homework.Task06;

public class TestTask06
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
        Task06.main(new String[]{"10", "3"});
        assertEquals("26 30", outContent.toString());
    }
    @Test
    public void test2()
    {
        Task06.main(new String[]{"33", "333"});
        assertEquals("732 10989", outContent.toString());
    }
}