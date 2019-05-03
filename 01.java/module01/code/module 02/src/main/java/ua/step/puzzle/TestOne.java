package ua.step.puzzle;

/**
 * 
 * Не запуская программу укажите, какое число будет выведено на консоль.
 *
 */
class TestOne
{
    public static void main(String[] args)
    {
        int i = 1;
        int n = ++i % 5;
        System.out.print(n + "");
        n = i-- % 4;
        System.out.print(+n + "");
        n = i++ % 2;
        System.out.print(n);
    }
}