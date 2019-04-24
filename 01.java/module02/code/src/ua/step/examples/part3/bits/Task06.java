package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.*;

import ua.step.examples.util.helper.BitOperationViewer;

/**
 * 
 * Бинарное отрицание (инвертирование битов) (NOT)
 *
 */
public class Task06
{
    public static void main(String[] args)
    {
        final int one = 123;
        printToBinary(one);
        System.out.println(" ~");
        int i = ~one; // NOT
        printToBinary(i);
        System.out.println(i);
        System.out.println();
        BitOperationViewer.main(new String[]{"NOT"});
    }
}