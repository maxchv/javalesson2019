package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task01_1;

public class TestTask01_1
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
        Task01_1.main(new String[] { "1", "2" });
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    public void test2()
    {
        Task01_1.main(new String[] { "2", "1" });
        assertEquals("0", outContent.toString().trim());
    }

    @Test
    public void test3()
    {
        Task01_1.main(new String[] { "3", "2" });
        assertEquals("1", outContent.toString().trim());
    }
    
    @Test
    public void test4()
    {
        Task01_1.main(new String[] { "-3", "2" });
        assertEquals("-1", outContent.toString().trim());
    }
    
    @Test
    public void test5()
    {
        Task01_1.main(new String[] { "-3", "-2" });
        assertEquals("-1", outContent.toString().trim());
    }
    
    @Test
    public void test6()
    {
        Task01_1.main(new String[] { "3", "-2" });
        assertEquals("1", outContent.toString().trim());
    }
}