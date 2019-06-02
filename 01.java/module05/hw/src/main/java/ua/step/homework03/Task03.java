package ua.step.homework03;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Создать массив из 200 случайных чисел в диапазоне от 0 до 200. Определить
 * количество одноразрядных, двухразрядных и трёхразрядных чисел. Вывести на
 * консоль полученный массив и количество в процентах по разрядам.
 *
 * Пример:
 * 		digit 1 = 4
 * 		digit 2 = 45
 * 		digit 3 = 39
 */
public class Task03 {
	public static void main(String[] args) {
		// TODO: не менять стоки ниже - нобходимо для тестирования
		//  @see ua.step.homework03.TaskTest03
		long seed = args != null && args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

		// Использовать для генерирования элементов массива
		Random rnd = new Random(seed);
		final int MIN = 0;
		final int MAX = 200;
		final int COUNT = 200;

		int[] arr;
		// TODO: Пишите код здесь
		arr = Stream.generate(() -> rnd.nextInt(Math.abs(MIN) + Math.abs(MAX) + 1) - Math.abs(MIN))
				.limit(COUNT).mapToInt(Integer::intValue).toArray();
				//.peek(System.out::println)
		System.out.println(Arrays.toString(arr));
		Arrays.stream(arr).boxed()
				.map(String::valueOf)
				.collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()))
				.entrySet().stream()
				.sorted(Comparator.comparingInt(Map.Entry::getKey))
				.forEach(e -> System.out.format("digit %d = %d%%%n", e.getKey(), e.getValue()*100/200));
	}
}
