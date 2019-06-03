package ua.step.example.util;

public class StringUtils {
	public static boolean isEmpty(CharSequence charSequence) {
		return charSequence == null || charSequence.length() == 0;
	}
}