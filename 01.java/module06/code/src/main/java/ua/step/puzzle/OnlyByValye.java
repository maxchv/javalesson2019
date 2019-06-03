package ua.step.puzzle;

public class OnlyByValye {
	public static void main(String[] args) {
		int x1 = 1;
		int[] x2 = { 1 };
		Integer x3 = 1;
		change(x1, x2, x3);
		System.out.println(x1 + x2[0] + x3);
	}

	private static void change(int x1, int[] x2, Integer x3) {
		x1++;
		x2[0]++;
		x3++;
	}
}
