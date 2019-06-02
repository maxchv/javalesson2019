package ua.step.homework03;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Задание: Сформировать целочисленный массив размером 20 элементов, значениями массива будут ква-
 * драты соответствующих индексов. Вывести результат на экран.
 *
 * Пример вывода:
 *
 * [0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361]
 *
 */
public class Task01 {
    public static void main(String[] args) {

        Integer[] arr = Stream.iterate(0, i -> i + 1)
                .limit(20).map(i -> i*i).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
