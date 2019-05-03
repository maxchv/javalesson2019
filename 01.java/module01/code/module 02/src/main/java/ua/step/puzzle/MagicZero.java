package ua.step.puzzle;

public class MagicZero
{
    public static void main(String[] args)
    {
        System.out.println(0 == -0);
        Integer f1 = new Integer(0);
        Integer f2 = new Integer(-0);
        System.out.println(f1 == f2);
        System.out.println(f1.equals(f2));
    }
}
