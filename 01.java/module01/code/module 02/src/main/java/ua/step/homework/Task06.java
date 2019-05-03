package ua.step.homework;

/*
* Шаблон для решения домашнеего задания
*/

/**
 * Есть прямоугольник у которого известна ширина width и высота height, 
 * найти и вывести на консоль периметр и площадь заданного
 * прямоугольника. Высота и ширина прямоугольника должна задаваться константными
 * переменными в коде программы.
 * Вывод: сначала периметр, через пробел площадь 
 *
 */
public class Task06
{
    public static void main(String[] args)
    {
        int width = 10;
        int height = 3;
        // две строки кода ниже нужны для тестирования (смотри Task06Test) 
        width = (args.length == 2) ? Integer.valueOf(args[0]) : width;
        width = (args.length == 2) ? Integer.valueOf(args[1]) : height;
        // используй переменные width и height для нахождения результата

    }
}