package org.itstep;

public class App {

    static int num = 1;

    public static void main(String[] args) {
        /*for(int i='a'; i<='z'; i++) {
            System.out.format("%c\t%c\t%d\t%s\n", i, i ^ 0b100000, i, Integer.toBinaryString(i));
        }*/
        String[] emails = {
            "vasja@pupkin.com",
            "@vasja",
            "pupkin.com",
            "masha@ukr.da"
        };
        for(String email: emails) {
            if(email.matches("\\w+@\\w+\\.\\w+")) {
                sendEmail(email, "Hello", "My message");
            }
        }

        int f = factorial(5);
        System.out.println("f = " + f);

        one();
    }

    static void one() {
        num++;
        two();
    }

    static void two() {
        num++;
        print();
    }

    static void print() {
        System.out.println(num);
    }

    private static int factorial(int n) {
        int f = 1;
        while(n > 0) {
            f *= n--;
        }
        return f;
    }

    // объявление метода
    protected static void sendEmail(String email, String subject, String message) {
        System.out.println("Send message to email " + email + " Subject: " +subject + " msg: " + message);
    }
}
