package ua.step.homework03;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 * Создать массив из 20 случайных чисел в диапазоне от -10 до 30. Написать
 * программу, определяющую сумму элементов массива, находящихся в массиве после
 * первого отрицательного элемента. Вывести на консоль полученный массив и
 * сумму.
 *
 */
public class Task02 {
	public static void main(String[] args) {
		// TODO: не менять стоки ниже - нобходимо для тестирования
		//  @see ua.step.homework03.TaskTest02
		long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

		// Использовать для генерирования элементов массива
		Random rnd = new Random(seed);
		final int MIN = -10;
		final int MAX = 30;

		int[] arr;
		// TODO: Пишите код здесь
		arr = Stream.generate(() -> rnd.nextInt(Math.abs(MIN) + Math.abs(MAX) + 1) - Math.abs(MIN))
					.limit(20)
				    .mapToInt(Integer::intValue)
				    .toArray();
		int sum = Arrays.stream(arr)
				         .dropWhile(i -> i > 0)
				         .skip(1)
						 //.peek(System.out::println)
				         .sum();
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
	}
}
