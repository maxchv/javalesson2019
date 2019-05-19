package ua.step.homework03;

import java.util.Arrays;

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
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i*i;
        }
        System.out.println(Arrays.toString(arr));
    }
}
