package ua.step.puzzle;

/**
 * 
 * Почему получается такой результат?
 *
 */
public class LongMagic {
	public static void main(String[] args) {
		System.out.println(magic(2) + magic(1l));
	}

	public static int magic(int i) {
		return i + i;
	}

	public static long magic(long i) {
		return i * i;
	}
}
