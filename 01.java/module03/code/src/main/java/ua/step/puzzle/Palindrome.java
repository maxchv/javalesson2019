package ua.step.puzzle;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число:");
		if (scanner.hasNextInt()) {
			int value = scanner.nextInt();
			int count = 1;
			int result = 0;
			for (int i = 10; value / i > 0; i *= 10) {
				count++;
			}
			for (int i = 10, j = (int) Math.pow(10, count);; i *= 10, j /= 10) {
				int balance = value % i;
				value -= balance;
				balance /= i / 10;
				result += balance * j;
				if (value / i == 0) {
					break;
				}
			}
			System.out.println(result / 10);
			scanner.close();
		}
	}
}
