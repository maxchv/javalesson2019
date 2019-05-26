package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание: Заполнить массив на 10 элементов случайными числами
 * от -5 до +5. Посчитать количество уникальных значений
 * (встречающихся в массиве один раз). Вывести на консоль
 * значения уникальных элементов и индексы, под которыми
 * они находятся в массиве.
 *
 *  Пример:
 *      -5 -> 0 индекс
 *      3 -> 1 индекс
 *      4 -> 2 индекс
 *      2 -> 3 индекс
 *      0 -> 4 индекс
 *      -2 -> 5 индекс
 *      -4 -> 6 индекс
 *      -1 -> 9 индекс
 */
public class Task06 {

    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest06
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        // TODO: Пишите код здесь
        List<Integer> arr = Stream.generate(() -> rnd.nextInt(11) - 5)
                .limit(10).collect(Collectors.toList());
        arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .forEach(n -> System.out.println(n.getKey() + " -> " + arr.indexOf(n.getKey()) + " индекс"));
    }
}
