package org.itstep;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Ctrl + Alt + L - форматирование кода

        System.out.println("My program started");

        // Создание объекта Scanner для считывание данных с клавиатуры
        // в консоли
        Scanner scanner = new Scanner(System.in);
        int a, b;
        System.out.print("a = ");
        a = scanner.nextInt(); // считывает и возвращает целое число введенное с клавиатуры
        System.out.print("b = ");
        b = scanner.nextInt();
        System.out.println("a + b = " + (a + b));
    }
}
