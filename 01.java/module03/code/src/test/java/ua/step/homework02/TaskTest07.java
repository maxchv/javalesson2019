package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest07 extends BaseTest {

	private final String number;
	private final String expected;

	public TaskTest07(String number, String expected) {
		super(null, Task07.class);
		this.number = number;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"123456", "654321"},
				{"987654", "456789"},
				{"123321", "123321"},
				{"111111", "111111"},
				{"121212", "212121"},
		});
	}

	@Test
	public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong reverse for number: %s", number);
        super.systemInputTest(number, expected, errorMessage);
	}
}
