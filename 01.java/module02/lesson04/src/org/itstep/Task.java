package org.itstep;

import java.util.Scanner;

/**
 * Практическое задание.
 * Необходимо написать программу, которая по введенному времени в часах выводила время
 * суток: ночь, утро, день или вечер.
 */
public class Task {

    private static final int DAY_END = 16;
    private static final int EVENING_START = DAY_END + 1;
    private static final int EVENING_END = 23;
    private static final int NIGHT_START = 0;
    private static final int NIGHT_END = 5;
    private static final int MORNING_START = NIGHT_END + 1;
    private static final int MORNING_END = 11;
    private static final int DAY_START = MORNING_END + 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Который сейчас час? ");
        int hour = scanner.nextInt();
        if(hour>= DAY_START && hour <= DAY_END) {
            System.out.println("Сейчас день");
        } else if(hour>= EVENING_START && hour <= EVENING_END) {
            System.out.println("Сейчас вечер");
        } else if(hour>= NIGHT_START && hour <= NIGHT_END) {
            System.out.println("Сейчас ночь");
        } else if(hour>= MORNING_START && hour <= MORNING_END) {
            System.out.println("Сейчас утро");
        } else {
            System.err.println("Некорректный ввод");
        }
    }
}
