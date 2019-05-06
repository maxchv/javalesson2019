package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertEquals;


public class TaskTest06 extends BaseTest {

	@Test
	public void test() {
		Task06.main(null);
		String errorMessage = "Wrong result";
		assertEquals(errorMessage, "43840", outContent.toString().trim());
	}
}
