package org.itstep;

import java.util.Arrays;
import java.util.Random;

public class Lesson03 {
    public static void main(String[] args) {
        char[] hi = {'Д', 'а'};
        String s = new String(hi);
        System.out.println(s);

        System.out.format("%.2f %g %e\n", Math.PI, Math.PI, Math.PI);
        for (int i = 0; i < s.length(); i++) {
            System.out.format("%d: %c code: %d\n", i, s.charAt(i), s.codePointAt(i));
        }

        s = "one".concat(" two"); // "one" + " two"; конкатенация
        System.out.println(s);


        String[] strings = new String[10];
        Random rnd = new Random();
        for (int i = 0; i < strings.length; i++) {
            int len = rnd.nextInt(20) + 1;
            byte[] buff = new byte[len];
            for (int j = 0; j < buff.length; j++) {
                buff[j] = (byte) (rnd.nextInt('z' - 'a' + 1) + 'a');
            }
            strings[i] = new String(buff);
        }

        System.out.println("\nUnsorted array: ");
        for (String str : strings) {
            System.out.println("str = " + str);
        }
        System.out.println();

        // Соритровка пузырьком
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                if (strings[j].length() > strings[j + 1].length()) {
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                }
            }
        }
        // Сортировка выбором

        System.out.println("Sorted array: ");
        for (String str : strings) {
            System.out.println("str = " + str);
        }
    }
}
