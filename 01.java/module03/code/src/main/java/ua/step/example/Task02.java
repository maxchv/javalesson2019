package ua.step.example;

/**
 * Цикл while - пока НЕ Использование блока кода
 */
public class Task02
{
    public static void main(String[] args)
    {
        int i = 0;
        while (i < 10)
        {
            // на каждой итерации цикла будет выполнятся две операции, которые
            // находятся в этом блоке кода
            System.out.print(i++);
            System.out.print(", ");
        }
    }
}