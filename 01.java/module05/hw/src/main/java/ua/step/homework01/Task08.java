package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание: Заполнить массив размерности n случайными строчны-
 * ми (маленькими) латинскими буквами. Подсчитать, сколько раз встреча-
 * ется каждая буква. Вывести буквы, которые встречаются
 * больше 2 раз. n – задается с клавиатуры.
 * <p>
 * Пример вывода:
 * g - 4 раза
 * l - 4 раза
 * s - 5 раз
 * v - 5 раз
 * x - 5 раз
 */
public class Task08 {
    public static void main(String[] args) {
        // TODO: не менять стоки ниже - нобходимо для тестирования @see ua.step.homework01.TaskTest08
        long seed = args.length > 0 ? Long.parseLong(args[0]) : LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        // Использовать для генерирования элементов массива
        Random rnd = new Random(seed);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int len = scanner.nextInt();

        int[] arr;
        // TODO: Пишите код здесь


        Function<Integer, String> text = (num) -> {
            switch (num) {
                case 4:
                    return "раза";
                default:
                    return "раз";
            }
        };
        Stream.generate(() -> (char) (rnd.nextInt(('z' - 'a' + 1)) + 'a'))
                .limit(len)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 3)
                .forEach((e) -> System.out.format("%c - %d %s\n", e.getKey(), e.getValue(), text.apply(e.getValue().intValue())));
    }
}
