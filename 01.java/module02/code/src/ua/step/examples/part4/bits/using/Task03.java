package ua.step.examples.part4.bits.using;

import static ua.step.examples.util.helper.Binary.printToBinary;

/**
 * 
 * Обратный код
 *
 */
public class Task03
{
    public static void main(String[] args)
    {
        int i = 10;
        printToBinary(i);
        i = ~i; // инвертирование битов числа
        printToBinary(i);
        i++; // прибавлении еденицы
        printToBinary(i);
        System.out.println(i);
    }
}