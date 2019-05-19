package ua.step.homework03;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.step.homework03.Task11;

public class TaskTest11 {
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
		String inputData = "125";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task11.main(null);
		String rezult = outContent.toString();
		assertTrue("Can be сто двадцать пять", rezult.contains("сто двадцать пять"));
	}

	@Test
	public void test2() {
		String inputData = "1001";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task11.main(null);
		String rezult = outContent.toString();
		assertTrue("Can be тысяча один", rezult.contains("тысяча один"));
	}

	@Test
	public void test3() {
		String inputData = "999999";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task11.main(null);
		String rezult = outContent.toString();
		String test = "девятьсот девяносто девять тысяч девятьсот девяносто девять";
		assertTrue("Can be " + test, rezult.contains(test));
	}

	@Test
	public void test4() {
		String inputData = "101010";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		Task11.main(null);
		String rezult = outContent.toString();
		String test = "сто одна тысяча десять";
		assertTrue("Can be " + test, rezult.contains(test));
	}

}
