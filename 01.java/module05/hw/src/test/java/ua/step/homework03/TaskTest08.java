package ua.step.homework03;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task08;

public class TaskTest08 {
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
	public void test1() {
		String inputData = "4";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String rezult = outContent.toString();
		int index = rezult.indexOf('1');
		String contecst = rezult.substring(index - 1);
		String[] rows = contecst.split("\\r\\n");
		assertTrue("Wrong order", rows[0].equals(" 1  2  3  4"));
		assertTrue("Wrong order", rows[1].equals("12 13 14  5"));
		assertTrue("Wrong order", rows[2].equals("11 16 15  6"));
		assertTrue("Wrong order", rows[3].equals("10  9  8  7"));
	}
	
	@Test
	public void test2() {
		String inputData = "5";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task08.main(null);
		String rezult = outContent.toString();
		int index = rezult.indexOf('1');
		String contecst = rezult.substring(index - 1);
		String[] rows = contecst.split("\\r\\n");
		assertTrue("Wrong order", rows[0].equals(" 1  2  3  4  5"));
		assertTrue("Wrong order", rows[1].equals("16 17 18 19  6"));
		assertTrue("Wrong order", rows[2].equals("15 24 25 20  7"));
		assertTrue("Wrong order", rows[3].equals("14 23 22 21  8"));
		assertTrue("Wrong order", rows[4].equals("13 12 11 10  9"));
	}
}