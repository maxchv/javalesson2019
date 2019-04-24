package org.itstep;

public class Application {
    public static void main(String[] args) {
        byte b = 127;
        int i = 0; // локальная переменная

        i = b; // неявное перобразование типов
        b = (byte)i; // явное преобразование типов

        System.out.println(b);

        // числа с плавающей точкой

        float f = 1.5f;

        long people = 7__000_000_000L;

        int two = 4;
        System.out.println(two);
        two = 04;
        System.out.println(two);
        two = 0x4;
        System.out.println(two);
        two = 0b100;
        System.out.println(two);

        char sym = 97;
        System.out.println(sym);
        sym = (char) (sym + 1);
        System.out.println(sym);
        sym = 'а';
        System.out.println((short)sym);

        long l = 7000_000_000L;

    }
}

class Test {

}
