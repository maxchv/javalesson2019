package ua.step.homework02;

import java.util.Scanner;

/**
 * Задание: С клавиатуры вводится целое положительное число любой разрядности. Необходимо
 * перевернуть это число, т. е. цифры должны располагаться в обратном порядке
 * (например, вводим число 1234 – в результате будет 4321).
 *
 * Не использовать строки и массивы.
 */
public class Task07 {
    public static void main(String[] args) {
        // TODO: этот код необходимо оставить неизменным для теста @see TaskTest07.java
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        boolean isInt = scanner.hasNextInt();
        int value = scanner.nextInt();
        scanner.close();

        // TODO: Здесь Ваш код

    }
}
