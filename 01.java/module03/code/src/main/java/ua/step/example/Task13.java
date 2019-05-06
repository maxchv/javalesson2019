package ua.step.example;

/**
 * 
 * Использование счетчика внешнего цикла в внутренем цикле
 *
 */
public class Task13
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 1; i < 100; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.print(sum);
    }
}
