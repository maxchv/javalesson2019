package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task05;

public class TestTask05
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
    public void test10()
    {
        Task05.main(new String[]{"10"});
        assertEquals("314.1592653589793 62.83185307179586", outContent.toString());
    }
    
    @Test
    public void test2()
    {
        Task05.main(new String[]{"2"});
        assertEquals("12.566370614359172 12.566370614359172", outContent.toString());
    }
}