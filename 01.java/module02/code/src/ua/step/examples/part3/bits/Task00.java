package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.printToBinary;

import ua.step.examples.util.switcher.BitsSwitcher;

/**
 * 
 * Побитовое представления числа
 */
public class Task00
{
    public static void main(String[] args)
    {
        byte bb = 10;
        System.out.println("Двоичное представление числа типа byte");
        printToBinary(bb);
        System.out.println();
        
        short sh = 10;
        System.out.println("Двоичное представлени числа типа short");
        printToBinary(sh);
        System.out.println();
        
        int in = 10;
        System.out.println("Двоичное представлени числа типа int");
        printToBinary(in);
        System.out.println();
        
        long lb = 10;
        System.out.println("Двоичное представлени числа типа long");
        printToBinary(lb);
        // FIXME измени числа на отрицательные, сравни результат
        BitsSwitcher.main(null);
    }
}