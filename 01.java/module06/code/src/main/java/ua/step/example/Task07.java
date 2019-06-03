package ua.step.example;

import java.util.Arrays;

/**
 * 
 * Перегрузка методов.
 * 
 */
public class Task07
{
    public static void main(String[] args)
    {
    	print();
    	print(2);
    	print("2");
    }

    static void print()
    {
        System.out.println("empty");
    }
    
    // метод имеет такое же имя, но один формальный параметр
    static void print(int i)
    {
        System.out.println("int value " + i);
    }

    // метод имеет такое же имя, один формальный параметр, но другого типа
    static void print(String s)
    {
        System.out.println("string " + s);
    }

    // static int print(String s)
    {
        // System.out.println("string " + s);
    }

    static void print(int[] mas)
    {
        System.out.println(Arrays.toString(mas));
    }
    // FIXME Дописать перегруженный метод для вывода массива строк не используя
    // класс Arrays. Дописать методы для вывода на консоль, двухмерных массивов
    // с различными типами данных (float, boolean, char).
}
