package org.itstep;

import java.util.Arrays;
import java.util.Random;

public class Lesson04 {
    public static void main(String[] args) {
        //demo1();

        // Методы строк
        String str = "one;two;three";
        int i = -1;
        while(true) {
            i = str.indexOf(";", i+1);
            if(i < 0){
                break;
            }
            System.out.println(i + ": " + str.substring(i+1, i+4));
        }
        String[] words = str.split(";");
        StringBuilder res = new StringBuilder();
        for(i=0; i<words.length; i++) {
            res.append(words[i]);
            res.append(" ");
        }
        System.out.println(res.toString());
    }

    private static void demo1() {
        int[] arr = new int[10];
        Random rnd = new Random(0);

        for (int i = 0; i < arr.length; i++) {
            // Инициализируем массив случаными числами
            arr[i] = rnd.nextInt(100);
        }
        int item;
        int j;
        for (int i = 0; i < arr.length; i++) {
            // FIXME: реализовать алгоритм сортировки вставками
            item = arr[i];
            for (j = i; j > 0 && arr[j - 1] > item; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = item;
        }
        int search = arr[rnd.nextInt(arr.length)];
        System.out.println("Нужно найти индекс элемента: " + search);
        //Arrays.sort(arr); // <-- тяжеловесная операция требует O(n2) итераций
        System.out.println(Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr, search);
        System.out.println("Найден индекс: " + idx);
    }
}
