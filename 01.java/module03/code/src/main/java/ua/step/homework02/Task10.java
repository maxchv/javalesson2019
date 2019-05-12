package ua.step.homework02;

import java.util.Scanner;

/**
 * Задание: Напишите программу, которая будет считывать с консоли целое положительное число
 * и выводить его цифры вертикально в виде звёздочек.
 * @see <a href='https://www.ascii-art-generator.org'>ascii art generator</a>
 *
 * Например, для числа 4107 вывод:
 *
 *  **  **
 *  **  **
 *  ******
 *      **
 *      **
 *  ****
 *    **
 *    **
 *    **
 *  ******
 *  ******
 *  **  **
 *  **  **
 *  **  **
 *  ******
 *  ******
 *      **
 *      **
 *      **
 *      **
 */
public class Task10 {
    public static void main(String[] args) {
        // TODO: этот код необходимо оставить неизменным для теста @see TaskTest10.java
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        scanner.close();

        // TODO: Здесь Ваш код
        System.out.println(
                " **  **  ****    ******  ******  ******  ******  ****    ******\n" +
                " **  **    **    **  **      **       *  **  **    **    **  **\n" +
                " ******    **    **  **      **  ******  ******    **    ******\n" +
                "     **    **    **  **      **  *       **  **    **        **\n" +
                "     **  ******  ******      **  ******  ******  ******  ******"
        );
    }
}
