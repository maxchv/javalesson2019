package ua.step.homework01;

import java.util.Scanner;

/**
 * Задание: Вывести бинарное представление значения переменной value типа int, используя только
 * один цикл, управляющую переменную, принт, и побитовые сдвиги << и >>>. Не
 * использовать готовые функции (методы). Число должно вводится с клавиатуры.
 * <p>
 * Пример работы программы:
 *      Введите число: 10
 *      1010
 *
 *      Введите число: 1
 *      1
 */
public class Task07 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        boolean isInt = scanner.hasNextInt();
        int value = scanner.nextInt();
        // TODO: Здесь Ваш код.

        scanner.close();
    }
}
