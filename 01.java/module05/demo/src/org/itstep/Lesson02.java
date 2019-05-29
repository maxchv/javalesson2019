package org.itstep;

import java.util.Arrays;

public class Lesson02 {
    public static void main(String[] args) {
        //System.arraycopy();
        //Arrays.copyOf()
        //Arrays.copyOfRange()
        int[][] marr = new int[10][5];
        Arrays.fill(marr[0], 100);
        for (int i = 0; i < marr.length; i++) {
            for (int j = 0; j < marr[i].length; j++) {
                System.out.print(marr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
