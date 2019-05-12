package ua.step.homework02;

import java.util.Scanner;

/**
 * Задание: Написать программу, которая выводит в консоль календарь на любой год,
 * указанный пользователем с клавиатуры. Календарь должен содержать дни недели в
 * каждом месяце.
 *
 * Существует довольно простой алгоритм вычисления дня недели для любой даты григорианского
 * календаря позднее 1583 года:
 *
 * a = (14 − месяц) / 12
 * y = год − a
 * m = месяц + 12 * a − 2
 * ДеньНедели = (день + y + y / 4 − y / 100 + y / 400 + (31 * m) / 12) ОСТАТОК 7
 *
 * @see <a href='https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%92%D0%B5%D1%87%D0%BD%D1%8B%D0%B9_%D0%BA%D0%B0%D0%BB%D0%B5%D0%BD%D0%B4%D0%B0%D1%80%D1%8C'>Вечный календарь</a>
 *
 * Пример вывода календаря на 2019 год:
 *
 *       January                   February                   March
 * Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
 *     1  2  3  4  5  6                   1  2  3                   1  2  3
 *  7  8  9 10 11 12 13       4  5  6  7  8  9 10       4  5  6  7  8  9 10
 * 14 15 16 17 18 19 20      11 12 13 14 15 16 17      11 12 13 14 15 16 17
 * 21 22 23 24 25 26 27      18 19 20 21 22 23 24      18 19 20 21 22 23 24
 * 28 29 30 31               25 26 27 28               25 26 27 28 29 30 31
 *
 *        April                      May                       June
 * Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
 *  1  2  3  4  5  6  7             1  2  3  4  5                      1  2
 *  8  9 10 11 12 13 14       6  7  8  9 10 11 12       3  4  5  6  7  8  9
 * 15 16 17 18 19 20 21      13 14 15 16 17 18 19      10 11 12 13 14 15 16
 * 22 23 24 25 26 27 28      20 21 22 23 24 25 26      17 18 19 20 21 22 23
 * 29 30                     27 28 29 30 31            24 25 26 27 28 29 30
 *
 *         July                     August                  September
 * Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
 *  1  2  3  4  5  6  7                1  2  3  4                         1
 *  8  9 10 11 12 13 14       5  6  7  8  9 10 11       2  3  4  5  6  7  8
 * 15 16 17 18 19 20 21      12 13 14 15 16 17 18       9 10 11 12 13 14 15
 * 22 23 24 25 26 27 28      19 20 21 22 23 24 25      16 17 18 19 20 21 22
 * 29 30 31                  26 27 28 29 30 31         23 24 25 26 27 28 29
 *                                                     30
 *
 *       October                   November                  December
 * Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su
 *     1  2  3  4  5  6                   1  2  3                         1
 *  7  8  9 10 11 12 13       4  5  6  7  8  9 10       2  3  4  5  6  7  8
 * 14 15 16 17 18 19 20      11 12 13 14 15 16 17       9 10 11 12 13 14 15
 * 21 22 23 24 25 26 27      18 19 20 21 22 23 24      16 17 18 19 20 21 22
 * 28 29 30 31               25 26 27 28 29 30         23 24 25 26 27 28 29
 *                                                     30 31
 *
 */
public class Task11 {

	public static void main(String[] args) {
		// TODO: этот код необходимо оставить неизменным для теста @see TaskTest11.java
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите год: ");
		final int DAYS_OF_MONTH = 7;
		final int YEAR = scanner.nextInt();
		int month = 1;
		int day = 1;
		int a = (14 - month) / 12;
		int y = YEAR - a;
		int m = month + 12 * a - 2;
		int dayOfMonth = (7000 + (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12)) % DAYS_OF_MONTH;
		// Результат: 0 — воскресенье, 1 — понедельник и т. д.

		// TODO: Здесь Ваш код

	}
}
