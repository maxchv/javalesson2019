package ua.step.homework;

import java.io.IOException;

/**
 * Даны координаты начала и координаты конца отрезка. Если считать
 * отрезок обозначением горки, то в одном случае он обозначает спуск, в другой
 * подъем. Определить и вывести на экран спуск это или подъем, ровная дорога или
 * вообще отвестная.
 * Пример Ввод 1 1 2 2 Вывод подъем
 * Пример Ввод 1 1 2 1 Вывод ровно
 */
public class Task09 {
    public static void main(String[] args) throws IOException {
        int x1 = 1;
        int y1 = 1;
        int x2 = 2;
        int y2 = 2;

        // строки ниже нужны для тестирования, не удаляйтее ее и не изменяйте
        x1 = (args.length > 0) ? Integer.valueOf(args[0]) : x1;
        y1 = (args.length > 1) ? Integer.valueOf(args[1]) : y1;
        x2 = (args.length > 0) ? Integer.valueOf(args[2]) : x2;
        y2 = (args.length > 1) ? Integer.valueOf(args[3]) : y2;

        // пишите код ниже испоьзуя переменные объявленные выше, проверить
        // решение можно запустив @see TestTask09.java

        // TODO: здесь ваш код

    }
}