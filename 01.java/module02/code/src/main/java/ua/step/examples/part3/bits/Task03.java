package ua.step.examples.part3.bits;

import static ua.step.examples.util.helper.Binary.*;

import ua.step.examples.util.helper.BitOperationViewer;

/**
 * 
 * Битовые операторы - ИЛИ (OR)
 */
public class Task03
{
    public static void main(String[] args)
    {
        final int one = 123;
        final int two = 456;
        printToBinary(one);
        System.out.println(" |");
        printToBinary(two);
        System.out.println(" =");
        int i = one | two; // OR - битовое или
        printToBinary(i);
        
        System.out.println(i);
        System.out.println();

        // ******************************************************
        
        //float f = 1.0f & 2.3f;
        //float f = 1.0f >> 2;
        BitOperationViewer.main(new String[]{"OR"});
    }
}