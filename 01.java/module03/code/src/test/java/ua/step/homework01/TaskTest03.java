package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertTrue;


public class TaskTest03 extends BaseTest {

	@Test
	public void test() {
		Task03.main(null);
		String errorMessage = "Wrong result";
		String expected = "2 3 4 5 6 7 8 9 153 370 371 407 1634 8208 9474 54748 92727 93084 548834 1741725 4210818 9800817 9926315";
		assertTrue(errorMessage ,  outContent.toString().contains(expected));
	}
}
