package ua.step.example;

/**
 * 
 * Не полные for
 *
 */
public class Task06
{
    public static void main(String[] args)
    {
        int i = 0;
        for (; i < 10; i++)
        {
            System.out.println(i);
        }

        System.out.println(i);
        
        for (; i < 10;)
        {
            System.out.println(i++);
        }
    }
}
