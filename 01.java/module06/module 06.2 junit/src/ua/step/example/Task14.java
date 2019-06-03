package ua.step.example;

// статический импорт
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * Игнорирование тестового метода
 *
 */
public class Task14
{
    @Ignore ("Причина игнорирования")
    @Test
    public void testIgnoredMethod()
    {
        fail("Опа-па");
    }
    
    @Test
    public void testFailMethod()
    {
        fail("тест");
    }
    
    @Test
    public void testMethod()
    {

    }

}