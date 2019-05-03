package ua.step.homework;
/*
* Шаблон для решения домашнеего задания 5
*/
/**
 * Подсчитать площадь и длину окружности для круга с радиусом R. Радиус задан
 * переменной с именем radius. Вывести результат на консоль.
 * Вывод: в одной строке через пробел, сначала окружность, потом площадь 
 */
public class Task05
{
    public static void main(String[] args)
    {
        int radius = 10;
        // данная строка нужна для тестирования (смотри Task05Test)
        radius = (args.length == 1) ? Integer.valueOf(args[0]) : radius;
    }
}