package ua.step.homework03;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task02;

public class TaskTest02 {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testLenght() {
		Task02.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		assertTrue("Elements should be 20", elements.length == 20);
	}

	@Test
	public void testValueRange() {
		Task02.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		for (String valueString : elements) {
			int value = Integer.valueOf(valueString);
			assertTrue("", value >= -10 && value <= 30);
		}
	}

	@Test
	public void testSum() {
		Task02.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		int sum = 0;
		boolean isNegativ = false;
		for (String element : elements) {
			int value = Integer.valueOf(element);
			if (!isNegativ) {
				if (value < 0) {
					isNegativ = true;
				}
				continue;
			}
			sum += value;
		}
		String summa = rezult.substring(end + 1);
		assertTrue(sum == Integer.valueOf(summa.trim()));
	}
}
