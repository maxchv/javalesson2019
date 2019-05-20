package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Задание: Заполнить массив размерности n случайными цифрами
 * от –2 до n. Если в массиве есть хотя бы одно отрицательное
 * значение меньше -1, заменить все отрицательные значение
 * в массиве на квадрат (в степени 2) этих значений. Вывести
 * исходный и результирующий массив на консоль.
 * <p>
 * Пример вывода:
 *      Исходный массив [9, 10, -2, 4, 0, 5, 1, 8, -1, 3]
 *      Результат [9, 10, 4, 4, 0, 5, 1, 8, 1, 3]
 */
public class Task09 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest09
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        int[] arr;
        // TODO: Пишите код здесь
        arr = IntStream.generate(() -> rnd.nextInt(len + 1 + 2) - 2)
                .limit(len)
                .toArray();
        System.out.println("Исходный массив " + Arrays.toString(arr));
        if(Arrays.stream(arr).anyMatch(item -> item == -2)) {
            arr = Arrays.stream(arr).map(item -> item < 0 ? item*item : item)
                    .toArray();
        }
        System.out.println("Результат " + Arrays.toString(arr));

    }
}
