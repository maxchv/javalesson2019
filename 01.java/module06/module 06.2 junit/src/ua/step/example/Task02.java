package ua.step.example;

import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * 
 * Тестирование времени работы метода.
 *
 */
public class Task02
{
    /**
     * Тестируемый метод
     */
    public int test(int value1, int value2)
    {
        int sum = 0;
        int n = 10_000;
        for (int i = 0; i < n; i++)
        {
            sum += value1 * value2;
        }
        return sum;
    }

    /**
     * Тестирующий метод проверяет результат, а так же чтобы метод выполнялся не
     * дольше 1 милисекунды.
     */
    @Test(timeout = 1)
    public void testMethod()
    {
        // подготовка входеых данных
        int value1 = 2;
        int value2 = 2;
        // вызов тестируемого метода и получение результата
        int result = test(value1, value2);
        // сверка результата с требованиями к работе метода
        assertSame(result, 40);
    }
}