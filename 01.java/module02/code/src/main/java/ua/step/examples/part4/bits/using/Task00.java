package ua.step.examples.part4.bits.using;

import static ua.step.examples.util.helper.Binary.*;

/**
 * Применение битовых операций. Упаковка и распоковка нескольких значений в
 * значение одной переменной.
 *
 */
public class Task00
{
    public static void main(String[] args)
    {
        byte age = 28; // 00011100
        short height = 185; // 10111001
        byte weight = 80; // 01010000

        System.out.print("Age    = ");
        printToBinary(age);
        System.out.print("Weight = ");
        printToBinary(weight);
        System.out.print("Height = ");
        printToBinary(height);

        // кодирование несколько чисел в одно
        int combined = (age) | (height << 8) | (weight << 16);

        System.out.println();
        System.out.println("Закодированное число = " + combined);
        System.out.println();
        System.out.println("          Битовое представление");
        System.out.println("        \u250cweight\u2510\u250cheight\u2510\u250c\u2500\u2500age\u2500\u2510");
        printToBinary(combined);
        System.out.println();

        // Извлечение скрытой информации
        int mask = 0xff; // 11111111
        System.out.print("Маска ");
        printToBinary(mask);
        age = (byte) (mask & combined);
        height = (short) (mask & combined >>> 8);
        weight = (byte) (mask & combined >>> 16);
        System.out.printf("Decode values Age: %d, height: %d, weight: %d \n", age, height, weight);

    }
}