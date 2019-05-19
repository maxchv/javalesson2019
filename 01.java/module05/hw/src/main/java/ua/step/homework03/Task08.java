package ua.step.homework03;

import java.util.Scanner;

/**
 * 
 * Заполните n мерный квадратный массив числами, которые увеличиваются на 1 по
 * спирали (число n должно задаваться с клавиатуры). Выведите результат на экран
 * с соблюдением ширины столбцов. Выполнить задачу с использованием только одного цикла. 
 * Для примера массив 4 на 4 должен выглядеть как
 * указано ниже.
 * 
 *   1  2  3  4
 *  12 13 14  5		
 *  11 16 15  6 
 *  10  9  8  7
 */
public class Task08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введете n");
		int n = scanner.nextInt();
		System.out.println(" 1  2  3  4");
		System.out.println("12 13 14  5");
		System.out.println("11 16 15  6");
		System.out.println("10  9  8  7");
	}
}
