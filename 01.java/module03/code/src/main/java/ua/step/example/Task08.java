package ua.step.example;

/**
 * 
 * Оператор прерывания выполнения блока кода
 *
 */
public class Task08
{
    public static void main(String[] args)
    {
        int i = 0;
        while (i < 10)
        {
            System.out.println(i);
            if (i >= i)
                break; // программа перейдет к строке 13
            i++;
        }

        // испоьзование метки для прерывания внешнего цикла
        two: for (int n = 0; n < 10; n++)
        {
            for (int j = 10; j > 0; j--)
            {
                System.out.print(j - n + " ");
                if (j + n == 5 && n > 0)
                    break two; // программа перейдет к строке 22
            }
        }

        // использования для прерывания блока кода
        one:
        {
            System.out.println("+");
            break one;
            // System.out.println("-");
        }
    }
}