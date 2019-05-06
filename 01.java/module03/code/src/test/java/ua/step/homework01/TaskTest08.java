package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertTrue;


public class TaskTest08 extends BaseTest {

	@Test
	public void test() {
		Task08.main(null);
		String errorMessage = "Wrong result";
		assertTrue(errorMessage ,  outContent.toString().trim().startsWith("00:00 01:10 02:20 03:30 04:40 05:50 10:01 11:11 12:21 13:31 14:41 15:51 20:02 21:12 22:22 23:32"));
	}
}
