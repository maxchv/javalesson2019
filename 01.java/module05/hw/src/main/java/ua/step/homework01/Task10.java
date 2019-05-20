package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Задание: Заполнить массив размерности n случайными циф-
 * рами от 0 до 33. Найти элемент массива, который делится
 * без остатка на значение элемента слева и значение элемен-
 * та справа. Вывести на консоль значения исходного массива.
 * Вывести индекс найденного элемента, если такой не найден,
 * вывести -1. n – задается с клавиатуры.
 * <p>
 * Пример вывода:
 *      Исходный массив [31, 0, 30, 3, 23, 1, 20, 29, 16, 2, 13, 9, 18, 9, 2]
 *      Индекс элемента 12
 */
public class Task10 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest10
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        int[] arr;
        // TODO: Пишите код здесь

        arr = IntStream.generate(() -> rnd.nextInt(34))
                .limit(len)
                .toArray();
        System.out.println("Исходный массив " + Arrays.toString(arr));

        System.out.print("Индекс элемента ");
        int idx = -1;
        for(int i=1; i<arr.length-1; i++) {
            if((arr[i-1] != 0 && arr[i] % arr[i-1] == 0) && (arr[i] % arr[i+1] == 0 && arr[i+1] != 0)) {
                if(arr[i] != 0) {
                    idx = i;
                }
            }
        }
        System.out.println(idx);
    }
}
