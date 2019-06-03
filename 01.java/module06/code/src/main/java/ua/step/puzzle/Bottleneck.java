package ua.step.puzzle;

/**
 * 
 * Напечатай b используя существующие методы. Сами методы менять нельзя. Новые
 * методы добавлять нельзя. System.out.println в main использовать нельзя.
 *
 */
@SuppressWarnings("unused")
public class Bottleneck
{
    public static void main(String[] args)
    {
        String s = null;
        print(s);
    }

    private static void print(String s)
    {
        System.out.println("a");
    }

    private static void print(Object s)
    {
        System.out.println("b");
    }

    private static void print(CharSequence s)
    {
        System.out.println("c");
    }
}
