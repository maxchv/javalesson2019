package ua.step.homework02;

import java.util.Scanner;

/**
 * Напишите программу, которая будет считывать с консоли любое число (от 0 до
 * 99999999) и выводить его цифры в виде звёздочек (см. рисунок):
 *
 */
public class Task10 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number");
		int number = scanner.nextInt();
		scanner.close();
	}
}
