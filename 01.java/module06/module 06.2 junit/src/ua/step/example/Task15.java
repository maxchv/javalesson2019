package ua.step.example;

import java.security.InvalidParameterException;

/**
 * 
 * Практическое задание 1
 *
 */
public class Task15
{
    /***************************************************************************
     * Метод calc производит целочисленные арифметические операции над входными
     * значениями из переменных value1 и value2. Тип операции задается символом
     * в переменной operator. Метод возврашает результат вычисления операции.
     *
     */
    public int calc(int value1, int value2, char operator)
    {
        switch (operator)
        {
            case '+':
                return value2 + value1;
            case '-':
                return value2 - value1;
            case '*':
                return value2 * value1;
            case '/':
                return value2 / value2;
        }
        // бросание исключительной ситуации
        throw new InvalidParameterException("Неверная операция");
    }

    // FIXME Напиши необхадимые тесты для всех операций данного метода. На
    // основании тестов, исправь ошибки в методе.
}