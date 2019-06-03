package ua.step.example;

import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * 
 * Проверка корректности работы метода, используя тестовый метод.
 *
 */
public class Task01
{
    /**
     * Тестируемый метод.
     * Возвращает сумму входных параметров
     */
    public int test(int value1, int value2)
    {
        // FIXME исправь код метода таким образом, чтобы тест проходил.
        // Напиши еще три тестовых метода проверяющих работу метода test
        return value1 + value2 + 1;
    }

    /**
     * Тестирующий метод
     */
    @Test
    public void testMethod()
    {
        // подготовка входеых данных
        int value1 = 2;
        int value2 = 2;
        // вызов тестируемого метода и получение результата
        int result = test(value1, value2);
        // сверка результата с требованиями к работе метода
        assertSame("Неверная сумма, результат должен быть равен 4", result, 4);
    }
}