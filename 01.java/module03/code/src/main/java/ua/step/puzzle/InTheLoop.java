package ua.step.puzzle;

/**
 * Требуется убрать только один символ, чтобы программа перестала зависать.
 * 
 */
public class InTheLoop
{
    public static final int END = Integer.MAX_VALUE;

    public static final int START = END - 100;

    public static void main(String[] args)
    {
        int count = 0;
        for (int i = START; i <= END; i++)
        {
            count++;
        }
        System.out.println(count);
        //FIXME почему программа не выходит из цикла?
    }
}
