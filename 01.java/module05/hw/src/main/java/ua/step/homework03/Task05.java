package ua.step.homework03;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Создать массив из 20 случайных чисел в диапазоне от -10 до 20. Определить
 * максимальное количество подряд идущих положительных элементов, не прерываемых
 * ни нулями, ни отрицательными числами. Вывести на консоль исходный массив и
 * найденный фрагмент (числа через пробел).
 */
public class Task05 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования
        //  @see ua.step.homework03.TaskTest05
        long seed = args != null && args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);
        final int MIN = -10;
        final int MAX = 20;
        final int COUNT = 20;

        int[] arr;
        // TODO: Пишите код здесь
        arr = Stream.generate(() -> rnd.nextInt(Math.abs(MIN) + Math.abs(MAX) + 1) - Math.abs(MIN))
                    .limit(COUNT).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));

        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {

        }

    }
}
