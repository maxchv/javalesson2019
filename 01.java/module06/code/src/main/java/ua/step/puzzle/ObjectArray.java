package ua.step.puzzle;

import java.lang.reflect.Array;

public class ObjectArray {
	public static void main(String[] args) {
		Object object = new int[] { 1, 2, 3 };
		for (int i = 0; i < Array.getLength(object); i++) {
			System.out.println(Array.get(object, i));
		}
	}
}