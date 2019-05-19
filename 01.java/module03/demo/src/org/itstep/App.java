package org.itstep;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        int i=-1;
//        while(i < 100) {
//            if(i % 2 == 1) {
//                continue;
//            }
//            System.out.println(i++);
//        }
//        Scanner scanner = new Scanner(System.in);
//        int num;
//        do {
//            System.out.print("Введите число больше нуля: ");
//            num = scanner.nextInt();
//        } while(num <= 0);
//        System.out.println("Вы ввели число " + num);

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }
    }
}
