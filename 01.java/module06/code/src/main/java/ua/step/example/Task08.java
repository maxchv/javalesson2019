package ua.step.example;

/**
 * 
 * Множественный параметр
 * 
 */
public class Task08 {
	public static void main(String... args) {
		System.out.println("main");
		print("Васька");
		print("Васька", "Том");
		print(1, "Васька", "Том");
	}

	static void print(String... strings) {
		for (String string : strings) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

	static void print(int i, String... strings) {
		for (String string : strings) {
			System.out.print(string + i + " ");
		}
		System.out.println();
	}

	// static void print( String... strings, float f) { } // ошибка, нельзя
	// указывать другие формальные параметры после множественного

}
