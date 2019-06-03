package ua.step.example;

public class Task06
{
    public static void main(String[] args)
    {
    	// вызов статического метода из другого класса.
    	int [][] mas = Task05.createIntMas(4, 4); 
        Task05.fillRandom(mas); 
        Task05.print(mas);
    }
    /**
     * Написать метод, который принимает в качестве формального параметра
     * массив целых чисел и изменяет значения каждого четного элемента
     * массива на противоположное. Вывести результат используя метод print из класса Task05.
     */

}
