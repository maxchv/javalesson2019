package ua.step.homework03;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * Создать массив из 20 случайных чисел в диапазоне от - 300 до 555. Написать
 * программу, копирующую один массив в другой следующим образом: сначала
 * копируются последовательно все элементы, большие 0, затем последовательно все
 * элементы, равные 0, а затем последовательно все элементы, меньшие 0. Вывести
 * исходный массив. Вывести результирующий массив.
 *
 */
public class Task04 {
	public static void main(String[] args) {
		// TODO: не менять стоки ниже - нобходимо для тестирования
		//  @see ua.step.homework03.TaskTest04
		long seed = args != null && args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

		// Использовать для генерирования элементов массива
		Random rnd = new Random(seed);
		final int MIN = -300;
		final int MAX = 555;
		final int COUNT = 20;

		int[] arr;
		// TODO: Пишите код здесь
		arr = Stream.generate(() -> rnd.nextInt(Math.abs(MIN) + Math.abs(MAX) + 1) - Math.abs(MIN))
				.limit(COUNT).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(arr));
		Integer[] result = Stream.concat(Stream.concat(Arrays.stream(arr).boxed().filter(i -> i > 0),
				Arrays.stream(arr).boxed().filter(i -> i == 0)),
				Arrays.stream(arr).boxed().filter(i -> i < 0))
				.toArray(Integer[]::new);
		System.out.println(Arrays.toString(result));
	}
}
