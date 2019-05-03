package ua.step.homework;
/*
* Шаблон для решения домашнеего задания 7
*/
/**
 * Напишите программу, которая позволит при известном годовом проценте 
 * вычислить сумму вклада в банке через два года,
 * если задана исходная величина вклада. Вывести результат вычисления в консоль.
 *
 */
public class Task07
{
    public static void main(String[] args)
    {
        int depositSumma = 1500;
        int annualPercentage = 3;
        // строки ниже нужны для тестирования, не удаляйтее ее и не изменяйте
        depositSumma = (args.length == 0) ? depositSumma : Integer.valueOf(args[0]);
        annualPercentage = (args.length == 0) ? annualPercentage : Integer.valueOf(args[1]);
        // пишите код ниже испоьзуя переменные объявленные выше, проверить
        // решение можно запустив @see TestTask07.java
    }
}
