package ua.step.homework;
/*
 * Шаблон для решения домашнеего задания. 
 */
/**
 * Написать программу расчета идеального веса к росту. В константах хранятся
 * рост (height) и вес (weight), вывести на консоль сообщение, сколько нужно кг
 * набрать или сбросить (идеальный вес = рост - 110). 
 * Вывод: положительное число если надо набрать вес, отрицательное если похудеть и ноль если вес идеальный
 */
public class Task10
{
    public static void main(String[] args)
    {
        int height = 198;
        int weight = 95;
        // две строки ниже нужны для автоматического теста
        height = (args.length == 2) ? Integer.valueOf(args[0]) : height;
        weight = (args.length == 2) ? Integer.valueOf(args[1]) : weight;

        // используй как входные данные переменные height и weight
    }
}
