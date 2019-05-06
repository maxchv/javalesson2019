package ua.step.homework01;

import org.junit.Test;
import ua.step.BaseTest;

import static org.junit.Assert.assertTrue;


public class TaskTest09 extends BaseTest {

    @Test
    public void test() {
        Task09.main(null);
        String errorMessage = "Wrong result";
        assertTrue(errorMessage, outContent.toString().contains("233168"));
    }
}
