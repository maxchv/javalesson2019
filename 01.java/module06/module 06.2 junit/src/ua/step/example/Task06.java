package ua.step.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Подготовка и уничтожение данных для тестовых методов
 *
 */
public class Task06
{
    // метод выполняется перед выполнением каждого тестового метода
    @Before
    public void begin()
    {
        System.out.println("BEFORE");
    }

    public void test(int[] mas)
    {
        System.out.println("TEST");
    }

    @Test
    public void testMethod1()
    {
        System.out.println("TEST METHOD 1");
    }

    @Test
    public void testMethod2()
    {
        System.out.println("TEST METHOD 2");
    }
    
    // метод выполняется после выполнением каждого тестового метода
    @After
    public void end()
    {
        System.out.println("AFTER");
    }
}