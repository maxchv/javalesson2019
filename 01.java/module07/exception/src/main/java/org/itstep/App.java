package org.itstep;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //demo();
        Point p1 = new Point(10, 20);

        //p1.setX(10); //p1.x = 10;
        //p1.setY(20); //p1.y = 20;
        p1.move(5,5);
        System.out.println("p1.getX() = " + p1.getX());
        System.out.println("p1.getY() = " + p1.getY());

    }

    private static void demo() {
        int birthYear = -1;
        int currentYear = LocalDate.now().getYear();

        Scanner scanner = new Scanner(System.in);

        Random rnd = new Random();
        boolean success = false;
        do {
            try {
                System.out.print("Birth year: ");
                String strYear = scanner.nextLine();
                isNumber(strYear);
                if(rnd.nextInt(2) == 0) {
                    throw new Exception("Random = 0");
                }
                birthYear = Integer.parseInt(strYear);
                int age = currentYear - birthYear;
                System.out.println("age = " + age);
                success = true;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid format");
            } catch (RuntimeException ex) {
                System.err.println("Other exception");
            } catch (Throwable ex) {
                System.err.println("General exception");
            }
        }while (!success);

        System.out.println("End of program");
    }

    static void isNumber(String str) {
        str = str.trim();
        for(int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                throw new RuntimeException("Invalid format");
            }
        }
    }
}
