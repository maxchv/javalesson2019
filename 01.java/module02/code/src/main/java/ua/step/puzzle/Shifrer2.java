package ua.step.puzzle;

import static ua.step.examples.util.helper.Binary.*;

public class Shifrer2
{
    public static void main(String[] args)
    {
        for (int i = Integer.MIN_VALUE; i < -1; i >>= 1)
        {
            printToBinary(i);
        }
        System.out.println();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE && i != 0; i >>>= 1)
        {
            printToBinary(i);
        }
    }
}