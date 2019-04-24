package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.*;

import ua.step.examples.util.helper.BitOperationViewer;

/**
 * 
 * Битовые операции - Исключающее ИЛИ (XOR)
 *
 */
public class Task05
{
    public static void main(String[] args)
    {
        final int one = 123;
        final int two = 456;
        printToBinary(one);
        System.out.println(" ^");
        printToBinary(two);
        System.out.println(" =");
        int i = one ^ two; // XOR битовое исключающее ИЛИ
        printToBinary(i);
        System.out.println(i);
        System.out.println();
        
        BitOperationViewer.main(new String[]{"XOR"});
    }
}