package ua.step.homework;

import java.io.IOException;

/**
 * Определить номер подъезда девятиэтажного дома по указанному номеру квартиры
 * room. Считать, что на каждом этаже находится m квартир. Вывести в консоль номер
 * подъезда.
 */
public class Task10 {
    public static void main(String[] args) throws IOException {
        final int FLOORS = 9; // этажей в доме
        int room = 127;
        int m = 4;

        // строки ниже нужны для тестирования, не удаляйтее ее и не изменяйте
        room = (args.length > 0) ? Integer.valueOf(args[0]) : room;
        m = (args.length > 1) ? Integer.valueOf(args[1]) : m;

        // пишите код ниже испоьзуя переменные объявленные выше, проверить
        // решение можно запустив @see TestTask10.java

        // TODO: здесь ваш код

    }
}