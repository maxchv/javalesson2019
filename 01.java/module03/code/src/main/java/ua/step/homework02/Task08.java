package ua.step.homework02;

import java.util.Scanner;

/**
 * С клавиатуры вводится целое число любой разрядности. Определить и выведите на
 * консоль количество цифр в этом числе и их сумму.
 *
 */
public class Task08 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number:");
		boolean isInt = scanner.hasNextInt();
		int value = scanner.nextInt();
		scanner.close();
	}
}
