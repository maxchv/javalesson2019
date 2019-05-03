package ua.step;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework.Task02;

public class TestTask02
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
    public void test0()
    {
        Task02.main(new String[] { "000" });
        assertEquals("0", outContent.toString());
    }

    @Test
    public void test1()
    {
        Task02.main(new String[] { "627" });
        assertEquals("15", outContent.toString());
    }

    @Test
    public void test2()
    {
        Task02.main(new String[] { "111" });
        assertEquals("3", outContent.toString());
    }

    @Test
    public void test3()
    {
        Task02.main(new String[] { "999" });
        assertEquals("27", outContent.toString());
    }

    @Test
    public void test4()
    {
        Task02.main(new String[] { "101" });
        assertEquals("2", outContent.toString());
    }
}