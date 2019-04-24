package org.itstep;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int a = 0b100;
        a <<= 2;
        System.out.println("decimal: " + a + " bin: " +Integer.toBinaryString(a));
        a =     0b011;
        int b = 0b001;
        int c = a ^ b;
        System.out.println("decimal a: " + a + " decimal b:" + b + " bin (a | b): "
                           + Integer.toBinaryString(c) + " decimal c: " + c);

        // Шифрование алгоритмом XOR

        byte key = 8;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваше сообщение: ");
        String origMessage = "Шифровка";// scanner.nextLine();
        System.out.println(origMessage);
        byte[] byteMessage = origMessage.getBytes();

        //System.out.println(Arrays.toString(byteMessage));
        for (int i = 0; i < byteMessage.length; i++) {
            byteMessage[i] ^= key;
        }
        //System.out.println(Arrays.toString(byteMessage));

        String encrMessage = new String(byteMessage);
        System.out.println(encrMessage);

        for (int i = 0; i < byteMessage.length; i++) {
            byteMessage[i] ^= key;
        }
        //System.out.println(Arrays.toString(byteMessage));

        String decrMessage = new String(byteMessage);
        System.out.println(decrMessage);

        System.out.println(Integer.toBinaryString(~0b0101));



    }
}
