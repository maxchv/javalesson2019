package ua.step.homework03;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task05;

public class TaskTest05 {
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
		Task05.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		assertTrue("Elements should be 20", elements.length == 20);
	}

	@Test
	public void testValueRange() {
		Task05.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		for (String valueString : elements) {
			int value = Integer.valueOf(valueString);
			assertTrue("", value >= -20 && value <= 20);
		}
	}

	@Test
	public void test() {
		Task05.main(null);
		String rezult = outContent.toString();
		int start = rezult.indexOf("[");
		int end = rezult.lastIndexOf("]");
		String masString = rezult.substring(start + 1, end);
		String[] elements = masString.split(", ");
		int last = 0;
		List<List<Integer>> rez = new ArrayList<List<Integer>>();
		List<Integer> r = new ArrayList<Integer>();
		for (String valueString : elements) {
			int value = Integer.valueOf(valueString);
			if (value > 0) {
				r.add(value);
			}
			if (last > 0 && value <= 0) {
				rez.add(r);
				r = new ArrayList<Integer>();
			}
			last = value;
		}
		int max = Integer.MIN_VALUE;
		for (List<Integer> values : rez) {
			if (values.size() > max) {
				max = values.size();
				r = values;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Integer integer : r) {
			sb.append(integer).append(" ");
		}
		assertTrue("Wrong result", rezult.contains(sb.toString().trim()));
	}
}