package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Scanner;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество уникальных значений
 * (встречающихся в массиве один раз). Вывести на консоль
 * значения уникальных элементов и индексы, под которыми
 * они находятся в массиве.
 */
public class Task06 {
	public static void main(String[] args) {
		// TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest02
		long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

		// Использовать для генерирования элементов массива
		Random rnd = new Random(seed);

		// TODO: Пишите код здесь
	}
}
