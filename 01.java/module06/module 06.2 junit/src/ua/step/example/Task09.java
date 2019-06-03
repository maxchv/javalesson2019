package ua.step.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Тестирование метода, который возвращает истину, если в массиве есть
 * отрицательные значения
 */
public class Task09
{
    // FIXME исправьте метод, чтобы все тесты проходили
    public boolean isNegativeExist(int[] mas)
    {
        return false;
    }

    @Test
    public void testNegativExist()
    {
        int[] input = { 1, -1 };
        boolean result = isNegativeExist(input);
        assertTrue(result);
    }

    @Test
    public void testNegativNotExist()
    {
        int[] input = { 1, 2 };
        boolean result = isNegativeExist(input);
        assertFalse(result);
    }

    @Test
    public void testEmptyArray()
    {
        int[] input = {};
        boolean result = isNegativeExist(input);
        assertFalse(result);
    }

    @Test
    public void testArrayIsNull()
    {
        int[] input = null;
        boolean result = isNegativeExist(input);
        assertFalse(result);
    }
}