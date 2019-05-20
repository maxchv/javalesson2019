package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Заполнить массив на 30 элементов случайными числами
 * от -70 до +50.
 * Найти минимальный элемент и максимальный элементы и вывести их на консоль через пробел
 */
public class Task02 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest02
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        // TODO: Пишите код здесь
        IntSummaryStatistics statistics = IntStream.generate(() -> rnd.nextInt(131) - 70)
                .limit(30)
                .summaryStatistics();
        System.out.print(statistics.getMin() + " " + statistics.getMax());

    }
}
