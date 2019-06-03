package ua.step.example;

import java.util.Random;

/**
 * 
 * Практическое задание
 *
 */
@SuppressWarnings("unused")
public class Task05 {
	public static void main(String[] args) {
		int row = 4;
		int col = 4;
		int[][] mas = createIntMas(col, row);
		// FIXME дописать программу - заполнив массив случайными числами и
		// вывести его на консоль используюя существующие методы. Протестировать
		// для массивов разного размера.

	}

	static int[][] createIntMas(int col, int row) {
		return new int[col][row];
	}

	// FIXME изменить метода таким образом, чтобы верхний предел задаваемых
	// значений можно было бы задавать при использовании метода. Оставить
	// возможность использовать старую сигнатуру.
	static void fillRandom(int[][] mas) {
		Random rnd = new Random();
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = rnd.nextInt(100);
			}
		}
		mas = new int[3][];
	}

	// FIXME дописать код метода, чтобы при его использовании массив выводился
	// на консоль в виде красивой таблички, например:
	// 23 188 31
	//  3   9 22
	//  4  67  0
	static void print(int[][] mas) {

	}
}