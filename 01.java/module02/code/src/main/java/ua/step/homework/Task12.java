package ua.step.homework;

import java.io.IOException;
import java.util.Scanner;

/**
 * Программа запрашивает шестизначное число, после ввода определяет будет ли
 * являтся счастливым билет с таким номером (сумма первых трех цифр совпадает с
 * сумой трех последних). Если число не шестизначное, вывести сообщение об ошибке. 
 * Пример входных данных: 423151 954832 Вывод: Да Нет
 * 
 * 
 */
public class Task12
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите шестизначное число:");
        int number = scanner.nextInt();
    }
}