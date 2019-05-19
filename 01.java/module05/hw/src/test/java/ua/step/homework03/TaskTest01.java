package ua.step.homework03;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task01;

public class TaskTest01 {
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
		Task01.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		assertTrue("Elements should be 20", elements.length == 20);
	}

	@Test
	public void test() {
		Task01.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		String result2 = rezult.substring(end + 3).trim();
		String[] elements2 = result2.split(" ");
		int j = 0;
		for (int i = 2; i < elements.length; i++) {
			if (i % 2 == 0) {
				assertTrue("Not equals", elements[i].equals(elements2[j++]));
			}
		}
	}
}
