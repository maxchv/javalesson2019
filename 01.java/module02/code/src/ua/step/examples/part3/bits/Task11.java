package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.*;

/**
 * 
 * Многократный сдвиг влево
 *
 */
public class Task11
{
    public static void main(String[] args)
    {
        int value = 0xFFFFFFFF;
        // сдвиг битов влево на 32 разряда вернет биты числа в начальное
        // состояние
        value <<= 32;
        printToBinary(value);
    }
}