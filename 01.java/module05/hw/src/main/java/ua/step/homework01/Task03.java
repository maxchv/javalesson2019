package ua.step.homework01;

import java.util.Scanner;

/**
 * Написать программу, которая проверяет, все ли значения
 * элементов массива одинаковые. Вывести: Yes – если все оди-
 * наковы и No – если имеется хоть одно различие.
 * Размер массива задается и инициализируется в начале программы.
 */
public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        // TODO: Пишите код здесь
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean all = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                all = false;
                break;
            }
        }
        System.out.println(all ? "yes" : "no");
    }
}
