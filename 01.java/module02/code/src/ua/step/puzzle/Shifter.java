package ua.step.puzzle;

import static ua.step.examples.util.helper.Binary.*;

public class Shifter
{
    public static void main(String[] args)
    {
        for (byte i = 1; i < Byte.MAX_VALUE && i != 0; i <<= 1)
        {
            printToBinary(i);
        }
        System.out.println();
        for (short i = 1; i < Short.MAX_VALUE && i != 0; i <<= 1)
        {
            printToBinary(i);
        }
        System.out.println();
        for (int i = 1; i < Integer.MAX_VALUE && i != 0; i <<= 1)
        {
            printToBinary(i);
        }
    }
}
