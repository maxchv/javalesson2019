package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Задание: Есть массив размером n элементов и заполненный
 * случайными числами в диапазоне от 0 до 100.
 * Необходимо разделить этот массив на массивы меньшего
 * размера в каждом из которых будет находиться не менее m элементов из
 * большого массива.
 * Значения n и m вводятся с клавиатуры пользователем.
 * Вывести на экран исходный массив и разделенный массив.
 *
 * Пример вывода:
 *
 * Исходный массив [35, 80, 39, 79, 63, 32, 89, 22, 29, 29]
 * Результат
 * [35, 80, 39]
 * [79, 63, 32]
 * [89, 22, 29]
 * [29]
 */
public class Task11 {

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest09
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массивов через пробел: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr;
        // TODO: Пишите код здесь
        arr = IntStream.generate(() -> rnd.nextInt(101))
                .limit(n)
                .toArray();
        System.out.println("Исходный массив " + Arrays.toString(arr));
        System.out.println("Результат");
        int[] marr;
        for(int i=0; i<n/m; i++) {
            marr = new int[(i*m)%m == 0 ? m : i*m%m];
            System.arraycopy(arr, i*m, marr, 0, marr.length);
            System.out.println(Arrays.toString(marr));
        }
        if(n%m != 0) {
            marr = new int[n%m];
            System.arraycopy(arr, n - marr.length, marr, 0, marr.length);
            System.out.println(Arrays.toString(marr));
        }
    }
}
