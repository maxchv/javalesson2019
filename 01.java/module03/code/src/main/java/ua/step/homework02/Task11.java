package ua.step.homework02;

/**
 * Написать программу, которая выводит в консоль календарь на любой год,
 * указанный пользователем с клавиатуры. Календарь должен содержать дни недели в
 * каждом месяце.
 *
 */
public class Task11 {
	public static void main(String[] args) {
		int year = 2016;
		int month = 1;
		int day = 1;
		int a = (14 - month) / 12;
		int y = year - a;
		int m = month + 12 * a - 2;
		int dayOfMonth = (7000 + (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12)) % 7;
		// Результат: 0 — воскресенье, 1 — понедельник и т. д.
	}
}
