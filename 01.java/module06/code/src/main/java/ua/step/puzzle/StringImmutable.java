package ua.step.puzzle;

/**
 * 
 * Почему метод test2 не меняет. 
 * Почему если закоментировать строку 20, а раскоментрировать 21 не происходит изменение массива.
 *
 */
public class StringImmutable {
	public static void main(String[] args) {
		String s1 = "hello";
		int mas[] = new int[3];
		test(mas);
		test2(s1);
		System.out.println(mas[0]);
		System.out.println(s1);
	}

	static void test(int massive[]) {
		massive[0] = 1;
		//massive = new int[]{1,1,1};
	}

	static void test2(String string) {
		string = string.concat("111");
	}
}