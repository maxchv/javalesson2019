package ua.step.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Подготовка и уничтожение данных для тестовых методов
 *
 */
public class Task07
{
    // метод выполняется перед выполнением всех тестовых методов этого класса
    @BeforeClass
    public static void begin()
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

     // метод выполняется после выполнения всех тестовых методов этого класса
    @AfterClass
    public static void end()
    {
        System.out.println("AFTER");
    }
}