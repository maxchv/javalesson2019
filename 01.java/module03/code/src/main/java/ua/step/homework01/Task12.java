package ua.step.homework01;

import java.util.Scanner;

/**
 * В первый день спортсмен пробежал x километров, а затем он каждый день
 * увеличивал пробег на 10% от предыдущего значения. По числу указаному с
 * клавиатуры y определите номер дня, на который пробег спортсмена составит не
 * менее y километров.
 */
public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float x = 0f, y = 0f;
        int day = 0;
        System.out.print("Введите сколько километров пробежал спортсмен в первый день: ");
        if (scanner.hasNextFloat()) {
            x = scanner.nextFloat();
        }
        System.out.print("Введите сколько километров спортсмен должен пробежать: ");
        if(scanner.hasNextFloat()) {
            y = scanner.nextFloat();
        }

        // TODO: Здесь Ваш код


        scanner.close();
    }
}
