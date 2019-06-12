package org.itstep;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Введите числитель: ");
        int denominator = sc.nextInt();
        System.out.println(1/denominator); */

        //System.out.println("Факториал числа 5: " + factorial(5));
        /*int[][][] arr = {
                {{ 1,  2,  3}, {4 ,  5,  6}, { 7,  8,  9}},
                {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}},
        };
        //System.out.println(Arrays.deepToString(arr));
        System.out.println(arr.getClass());
        int[][] arr2 = arr[0];
        int[] arr1 = arr2[0];
        System.out.println(arr1 instanceof int[]);*/
        String abba = "ABBA";
        boolean palindrome = isPalindromeByLoop(abba);
        System.out.println(palindrome);
        palindrome = isPalindromeByRecursion(abba);
        System.out.println(palindrome);
    }

    static boolean isPalindromeByRecursion(String s) {
        if(s.length() <= 1) {
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
//        return  false;

       return isPalindromeByRecursion(s.substring(1, s.length() - 1));
    }

    static boolean isPalindromeByLoop(String s) {
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Вычисляет факториал числа n
     *
     * @param n - положительное число для вычисления факториала
     * @return факториал
     */
    static int factorial(int n) {
        if (n < 0) {
            throw new RuntimeException("Не существует для " + n);
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
