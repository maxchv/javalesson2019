package ua.step.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * Использование проверок результата типа boolean
 *
 */
public class Task03
{
    @Test
    public void testBoolean1()
    {
        boolean value = true;
        assertTrue("Не истина", value);
    }

    @Test
    public void testBoolean2()
    {
        boolean value = false;
        assertFalse("Не ложь", value);
    }
}