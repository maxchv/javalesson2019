package ua.step.homework03;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task04;

public class TaskTest04 {
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
		Task04.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		assertTrue("Elements should be 20", elements.length == 20);
	}

	@Test
	public void testValueRange() {
		Task04.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		for (String valueString : elements) {
			int value = Integer.valueOf(valueString);
			assertTrue("", value >= -300 && value <= 255);
		}
	}

	@Test
	public void test() {
		Task04.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		boolean isNegativ = false;
		boolean isZerro = false;
		boolean isPosetiv = false;
		for (String valueString : elements) {
			Integer value = Integer.valueOf(valueString);
			if (value < 0) {
				isNegativ = true;
			} else if (value > 0) {
				if (isZerro || isNegativ) {
					fail("Wrong order");
				}
				isPosetiv = true;
			} else {
				if (isNegativ) {
					fail("Wrong order");
				}
				isZerro = true;
			}
		}
	}
}