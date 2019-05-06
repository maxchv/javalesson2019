package ua.step.example;

/**
 * Цикл do while - пока НЕ (постусловие) тело цикла с do while будет всегда
 * выполнено один раз, так как услови окончания цикла проверяется после
 * выполнения тела
 */
public class Task03
{
    public static void main(String[] args)
    {
        int i = 0;
        do
        {
            i++;
            System.out.println(i);
        } while (i > 10);
        // FIXME измени условие цикла, чтобы выводился только 0
    }
}
