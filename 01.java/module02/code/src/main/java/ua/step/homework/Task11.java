package ua.step.homework;

import java.io.IOException;
import java.util.Locale;

/**
 * Найти корни квадратного уравнения и вывести их на экран, если они есть. Если
 * корней нет, то вывести сообщение об этом. Конкретное квадратное уравнение
 * определяется коэффициентами a, b, c, которые вводит пользователь с
 * клавиатуры.
 */
public class Task11 {
    public static void main(String[] args) throws IOException {
        int a = 1;
        int b = 2;
        int c = 3;

        // строки ниже нужны для тестирования, не удаляйтее ее и не изменяйте
        a = (args.length > 0) ? Integer.valueOf(args[0]) : a;
        b = (args.length > 1) ? Integer.valueOf(args[1]) : b;
        c = (args.length > 1) ? Integer.valueOf(args[2]) : c;

        // пишите код ниже испоьзуя переменные объявленные выше, проверить
        // решение можно запустив @see TestTask10.java


        System.out.printf("%dx^2+%dbx + %d=0\n", a, b, c);

        double x1 = 0, x2 = 0;

        // TODO: здесь ваш код


        // TODO: не меняйте строку вывода
        System.out.printf(Locale.ENGLISH, "x1 = %.3f, x2 = %.3f", x1, x2);
    }
}