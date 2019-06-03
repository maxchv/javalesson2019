package ua.step.example;

/**
 * 
 * Рекурсия
 * 
 */
public class Task09
{
    public static void main(String[] args)
    {
        error();
        count(0);
    }
    
    // произойдет зацикливание и переполнение стэка 
    static void error()
    {
        error(); // метод вызывает себя же в своем теле
    }

    static void count(int number)
    {
        if (number < 10)
        {
            // System.out.println(number);
            count(++number);
            // System.out.println(number);
        }
        //System.out.println(number);
    }
}
