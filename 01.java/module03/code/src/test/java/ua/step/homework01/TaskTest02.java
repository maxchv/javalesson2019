package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertTrue;


public class TaskTest02 extends BaseTest {
	@Test
	public void test() {
		Task02.main(null);
		String errorMessage = "Wrong result";
		String expected = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103";
		assertTrue(errorMessage ,  outContent.toString().startsWith(expected));
	}
}
