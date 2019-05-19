package ua.step.homework01;

import java.util.stream.IntStream;

/**
 * Заполнить массив на 15 элементов числами Фибоначчи.
 * Вывести на консоль только четные элементы массива.
 *
 * Пример вывода:
 *  1 2 5 13 34 89 233 610
 */
public class Task01 {
    public static void main(String[] args) {
		// TODO: Пишите код здесь

        int[] arr = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        IntStream.range(0, arr.length)
                .filter(i -> i%2 == 0)
                .forEach(i -> System.out.print(arr[i] + " "));
    }
}