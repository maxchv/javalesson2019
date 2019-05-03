package ua.step.homework;

/**
 * Есть три переменных a, b и с эти переменный явно записаны три целых попарно
 * неравных между собой числа. Создать программу, которая переставит числа в
 * переменных таким образом, чтобы при выводе на экран последовательность a, b и
 * c оказалась строго возрастающей. Пример 7 4 5 Вывод 4 5 7
 */
public class Task03 {
    public static void main(String[] args) {
        int a = 7;
        int b = 4;
        int c = 5;
        // строки ниже нужны для тестирования, не удаляйтее ее и не изменяйте
        a = (args.length > 0) ? Integer.valueOf(args[0]) : a;
        b = (args.length > 1) ? Integer.valueOf(args[1]) : b;
        c = (args.length > 2) ? Integer.valueOf(args[2]) : c;
        // пишите код ниже испоьзуя переменные объявленные выше, проверить
        // решение можно запустив @see TestTask03.java

        // TODO не менять строку вывода
        System.out.printf("%d %d %d", a, b, c);

        // TODO: здесь ваш код
    }
}