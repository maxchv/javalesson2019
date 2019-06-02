package ua.step.homework03;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task03;

public class TaskTest03 {
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
		Task03.main(new String[]{"0"});
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		assertTrue("Elements should be 200", elements.length == 200);
	}

	@Test
	public void testValueRange() {
		Task03.main(new String[]{"0"});
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		for (String valueString : elements) {
			int value = Integer.valueOf(valueString);
			assertTrue("", value >= 0 && value <= 200);
		}
	}

	@Test
	public void testSum() {
		Task03.main(new String[]{"0"});
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		for (String valueString : elements) {
			switch (valueString.length()) {
			case 1:
				sum1++;
				break;
			case 2:
				sum2++;
				break;
			case 3:
				sum3++;
				break;
			}
		}
		assertTrue("Can be " + sum1, rezult.contains("digit 1 = " + sum1 * 100 / 200 + "%"));
		assertTrue("Can be " + sum2, rezult.contains("digit 2 = " + sum2 * 100 / 200 + "%"));
		assertTrue("Can be " + sum3, rezult.contains("digit 3 = " + sum3 * 100 / 200 + "%"));
	}
}