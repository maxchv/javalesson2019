package ua.step.homework03;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Создать квадратный массив размерностью NxN заполненный случайными числами,
 * вывести массив на экран в виде таблицы, найти наименьший и наибольший элемент
 * массива и вывести их на экран (если найдено несколько одинаковых элементов —
 * вывести через запятую индексы строки и столбца, где есть повторения). Вывести на экран
 * время выполнения поиска, в миллисекундах. Размерность массива должна
 * задаваться с клавиатуры.
 *
 */
public class Task07 {
	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введете n");
		int n = scanner.nextInt();
	}
}
