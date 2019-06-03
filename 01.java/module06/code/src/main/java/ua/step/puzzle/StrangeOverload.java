package ua.step.puzzle;

@SuppressWarnings("unused")
public class StrangeOverload
{
    public static void main(String[] args)
    {
        byte b = 1;
        action(b, b);
    }

    private static void action(byte... args)
    {
        System.out.println("Multi arguments");
    }

    private static void action(long l1, short s2)
    {
        System.out.println("What the hell?");
    }

    private static void action(Byte b, Byte b2)
    {
        System.out.println("Autoboxing is cool");
    }
}