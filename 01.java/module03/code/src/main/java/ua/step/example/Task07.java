package ua.step.example;

/**
 * 
 * Комбинированный for
 *
 */
public class Task07
{
    public static void main(String[] args)
    {
        for (int i = 1, j = 3; i < 5 & j > 0; i++, --j)
        {
            System.out.println("i = " + i + " j = " + j);
        }
    }
}
