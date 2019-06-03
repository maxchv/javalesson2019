package ua.step.example;

/**
 * 
 * Возврат значения из метода
 * 
 */
public class Task04 {
	public static void main(String[] args) {
		int sum = sum(2, 2); // использование результата работы метода в
								// присваивании
		System.out.println(sum);

		// можно использовать метод без присваивания возврашаемого значения
		sum(2, 2);  
		// System.out.println(sum);

		// можно использовать с присваиванием
		sum = sum(3, 3); 
		// System.out.println(sum);
		
		// можно использовать результат работы метода как фактический параметр метода
		sum = sum(sum(2, 2), 3); 
		// System.out.println(sum);

		// FIXME изменить программу так чтобы она выводила на консоль Hello
		// world!!! n раз. Используйте для этого существующие методы.

	}


	// возвращает значение типа int
	static int sum(int i, int j) {
		return i + j;
	}

	// возвращает значение типа String
	static String getHelloWorld() {
		return "Hello world!!!";
	}
}