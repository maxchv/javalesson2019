package ua.step.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Палиндром — это последовательность символов, которая слева-направо и
 * справа-налево пишется одинаково. Например «АБА» или «АББ ББА». Дана
 * последовательность символов. Программа должна вывести какое минимальное
 * количество символов нужно удалить из строки, чтобы получить палиндром. Вывести
 * полученный палиндром. Длина последовательности не больше 20 символов,
 * вводится с клавиатуры.
 */
public class Task02 {
    public static void main(String[] args) {
        String word = "ADDC";
        boolean palindrome = is_palindrome(word);
        System.out.println("palindrome = " + palindrome);
        String result = canBePalindrome(word);
        System.out.println("result = " + result);
    }

    private static String canBePalindrome(String word) {
        Map<Character, Long> collect = word.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        int count = 0;
        for(Map.Entry<Character, Long> item: collect.entrySet()) {
            if(item.getValue() == 1) {
                System.out.println("Remove all: " + item.getKey());
                count++;
                word = word.replace(item.getKey().toString(), "");
            } else if(item.getValue() % 2 == 1) {
                System.out.println("Remove one: " + item.getKey());
                count++;
            }
        }
        System.out.println("Нужно удалить " + count + " символов");
        return word;
    }


    private static boolean is_palindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        return word.charAt(0) == word.charAt(word.length() - 1) && is_palindrome(word.substring(1, word.length() - 1));
    }
}
