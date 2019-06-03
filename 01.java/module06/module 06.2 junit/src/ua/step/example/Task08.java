package ua.step.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Метода getHalf, должен возвращать первую половину строки. Если число символов
 * в строке не четное, в первую половину должен входить центральный символ. Если
 * строка пустая или null метод должен вернуть пустую строку.
 */
public class Task08
{
    // FIXME Исправь метод getHalf чтобы он работал согласно требованиям к
    // задаче и тестам
    public String getHalf(String value)
    {
        int mid = value.length() / 2;
        return value.substring(mid);
    }

    @Test
    public void testAbcde()
    {
        String input = "ABCDE";
        String result = getHalf(input);
        assertEquals("Неверный результат", result, "ABC");
    }

    @Test
    public void testAbcd()
    {
        String input = "ABCD";
        String result = getHalf(input);
        assertEquals("Неверный результат", result, "AB");
    }

    @Test
    public void testA()
    {
        String input = "A";
        String result = getHalf(input);
        assertEquals("Неверный результат", result, "A");
    }

    @Test
    public void testEmpty()
    {
        String input = "";
        String result = getHalf(input);
        assertEquals("Неверный результат", result, "");
    }

    @Test
    public void testNull()
    {
        String input = null;
        String result = getHalf(input);
        assertEquals("Неверный результат", result, "");
    }
}