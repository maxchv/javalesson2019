package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.*;

/**
 * 
 * Многократный беззнаковый сдвиг вправо
 *
 */
public class Task12
{
    public static void main(String[] args)
    {
        int value = 0xF0F0F0F0;
        // сдвиг битов вправо на 32 разряда тоже вернет биты в начальное положение
        printToBinary(value >> 16);
        // точно так же как и беззнаковый
        printToBinary(value >>> 16);
        // FIXME исправь сдвиг на 32
    }
}