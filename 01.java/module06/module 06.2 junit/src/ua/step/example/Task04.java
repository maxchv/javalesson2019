package ua.step.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * 
 * Использование проверок для ссылочных типов
 *
 */
@SuppressWarnings("unused")
public class Task04
{
    @Test
    public void testSameVsEquals0()
    {
        String s1 = "abc";
        String s2 = "abc";
        // проверяет чтобы ссылки были равны
        assertSame("Строки не равны", s1, s2);
    }

    @Test
    public void testSameVsEquals1()
    {
        String s1 = new String("abc");
        String s2 = new String("abc");
        // проверяет чтобы ссылки были НЕ равны
        assertSame("Ссылки не равны ", s1, s2);
        // assertEquals(s1, s2);
    }

    @Test
    public void testArrayEquals()
    {
        int[] mas1 = { 1, 2, 3 };
        int[] mas2 = { 1, 2, 3 };
        // сравнивает содержимое строк вызывая метод equals у строк
        assertEquals("Нельзя применять для массивов", mas1, mas2);
        // assertArrayEquals(mas1, mas2);
    }

    @Test
    public void testNull()
    {
        String s1 = null;
        // проверяет равна ли ссылка null
        assertNull(s1);
        // проверяет чтобы ссылка НЕ была рвна null
        assertNotNull(s1);
    }
}