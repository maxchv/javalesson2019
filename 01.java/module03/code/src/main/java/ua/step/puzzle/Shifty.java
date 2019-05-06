package ua.step.puzzle;

public class Shifty
{
    public static void main(String[] args)
    {
        int i = 0;
        while (-1 << i != 0)
        {
            i++;
        }
        System.out.println(i);
        //FIXME почему программа не выходит из цикла?
    }
}
