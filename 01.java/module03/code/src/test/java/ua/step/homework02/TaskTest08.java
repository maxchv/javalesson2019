package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest08 extends BaseTest {

//	@Test
//	public void test() {
//		String inputData = String.valueOf(123456);
//		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
//		Task08.main(null);
//		String errorMessage = "Wrong result";
//		assertTrue(errorMessage, outContent.toString().trim().contains("6 21"));
//	}

	private final String number;
	private final String expected;

	public TaskTest08(String number, String expected) {
		super(null, Task08.class);
		this.number = number;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"123456", "6 21"},
				{"456123", "6 21"},
				{"321654", "6 21"},
		});
	}

	@Test
	public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		if(testClass == null) return;
		String errorMessage = String.format("Wrong result for number: %s", number);
		super.systemInputTest(number, expected, errorMessage);
	}
}
