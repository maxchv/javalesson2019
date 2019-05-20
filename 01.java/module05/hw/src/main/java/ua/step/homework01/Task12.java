package ua.step.homework01;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Программа должна выводить слово Yes для симметрич-
 * ного массива и слово No – для несимметричного. Симме-
 * тричным считается массив, в котором значения элементов с
 * конца равно значению элементов с начала. Массив заполняется
 * пользователем вручную.
 * Размер массива (количество строк и колонок) задается при
 * запуске программы.
 *
 * Примеры значений для симметричного массива:
 * <p>
 * 1, 2, 3, 2, 1
 * 2, 2, 3, 2, 2
 * 1, 3, 2, 3, 1
 * 5, 4, 3, 4, 5
 *
 *
 */
public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размернось массива (сколько строк и колонок): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] marr;
        // TODO: Пишите код здесь
        marr = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                marr[i][j] = scanner.nextInt();
            }
        }
        String res = "yes";
        for(int i=0; i<rows; i++) {
            if(marr[i][0] != marr[i][cols-1]) {
                res = "no";
                break;
            }
        }
        System.out.println(res);
    }
}
