package ua.step.homework;

import java.io.IOException;

/**
 * Найти корни квадратного уравнения и вывести их на экран, если они есть. Если
 * корней нет, то вывести сообщение об этом. Конкретное квадратное уравнение
 * определяется коэффициентами a, b, c, которые вводит пользователь с
 * клавиатуры.
 * 
 */
public class Task11
{
    public static void main(String[] args) throws IOException
    {
        int a = 1;
        int b = 2;
        int c = 3;
        System.out.printf("%dx^2+%dbx + %d=0\n", a, b, c);
    }
}