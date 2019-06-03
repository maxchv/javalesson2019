package ua.step.example;

import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * 
 * Тестирование времени работы метода.
 *
 */
public class Task05
{
    /**
     * Тестируемый метод
     */
    public int test(int value1, int value2)
    {
        return value1 / value2;
    }

    /**
     * Тестирующий метод проверяет что при указанных входных данных, метод
     * бросит исключение во время выполнение программы
     */
    @Test(expected = ArithmeticException.class)
    public void testMethod()
    {
        // подготовка входеых данных
        int value1 = 2;
        int value2 = 0;
        // вызов тестируемого метода и получение результата
        int result = test(value1, value2);
        // сверка результата с требованиями к работе метода
        assertSame(result, 2);
    }
}