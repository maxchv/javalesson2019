package ua.step.homework02;

import java.util.Scanner;

/**
 * С клавиатуры вводится целое число любой разрядности. Определить и выведите на
 * консоль количество цифр в этом числе, через пробле - их сумму.
 *
 * Пример:
 * Вводим число: 123456
 * Получаем вывод: 6 21
 */
public class Task08 {

    public static void main(String[] args) {
        // TODO: этот код необходимо оставить неизменным для теста @see TaskTest08.java
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        boolean isInt = scanner.hasNextInt();
        int value = scanner.nextInt();
        scanner.close();

        // TODO: Здесь Ваш код
    }
}
