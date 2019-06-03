package ua.step.example;

/**
 * 
 * Сложная рекурсия
 *
 */
public class Task13
{
    public static void main(String[] args)
    {
        a();
    }
    
    static void a()
    {
        b();
    }

    private static void b()
    {
        a();
    }
}
