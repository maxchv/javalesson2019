package ua.step.homework;

import java.util.Scanner;

/**
 * Организовать ввод с клавиатуры даты рождения человека, программа должна
 * вывести знак зодиака и названия года по китайскому календарю.
 * Пример входных данных: 5 12 1974
 * Вывод: Знак: стрелец Год: тигра
 */
public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату рождения человека в виде трех чисел (дата, месяц, год): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        // TODO: здесь ваш код
        //Знаки зодиака (Западная астрология вариант 1 википедия)

    }
}