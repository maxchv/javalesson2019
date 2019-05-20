package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество повторяющихся значе-
 * ний. Вывести на консоль только повторяющиеся элементы
 * и количество повторений.
 *
 * Пример:
 * 		0 – 5 раз
 * 		2 – 3 раза
 * 		7 – 1 раз
 */
public class Task05 {
	public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest05
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        // TODO: Пишите код здесь
        Stream.generate(() -> rnd.nextInt(11) - 5)
                .limit(10)
                .sorted()
                //.peek(System.out::println)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                //.peek(System.out::println)
                .filter(e -> e.getValue() > 1)
                .forEach((e) -> System.out.format("%d - %d раза\n", e.getKey(), e.getValue()));
	}
}
