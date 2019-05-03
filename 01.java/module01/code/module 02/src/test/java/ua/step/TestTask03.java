package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task03;

public class TestTask03
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
        Task03.main(new String[] {"0.1"});
        assertEquals("0", outContent.toString().trim());
    }
    
    @Test
    public void test2()
    {
        Task03.main(new String[] {"0.5"});
        assertEquals("1", outContent.toString().trim());
    }
    
    @Test
    public void test3()
    {
        Task03.main(new String[] {"1.0"});
        assertEquals("1", outContent.toString().trim());
    }
    
    @Test
    public void test4()
    {
        Task03.main(new String[] {"1.2"});
        assertEquals("1", outContent.toString().trim());
    }
    
    @Test
    public void test5()
    {
        Task03.main(new String[] {"1.9"});
        assertEquals("2", outContent.toString().trim());
    }
}