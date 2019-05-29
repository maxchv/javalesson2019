package org.itstep;

import java.util.Arrays;
import java.util.Random;


public class App {
    public static void main(String[] args) {
//        System.out.println("Min: " + Integer.toBinaryString(Integer.MIN_VALUE)
//                        + " Max: " + Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println("Min: " + Short.MIN_VALUE + " Max: " + Short.MAX_VALUE);
        int[] arr = {1,2,3};
        arr[0] += 5;
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
        System.out.println("For");
        for(int i=0; i<arr.length; i++) {
            int item = arr[i];
            System.out.println(item);
        }

        System.out.println("Foreach");
        for(int item: arr) {
            System.out.println(item);
        }
        String stringReprArray = Arrays.toString(arr);
        System.out.println(stringReprArray);

        Random rnd = new Random();

        int m = 5;
        int n = 10;
        for(int i=0; i<100; i++) {
            int r = rnd.nextInt(m+1) + (n - m);
            System.out.print(r + ", ");
        }
    }
}
