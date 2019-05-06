package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertTrue;


public class TaskTest01 extends BaseTest {

	@Test
	public void test() {
		Task01.main(null);
		String errorMessage = "Wrong result";
		String expected = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465";
		assertTrue(errorMessage ,  outContent.toString().contains(expected));
	}
}
