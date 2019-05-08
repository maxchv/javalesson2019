package ua.step.homework01;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.step.BaseTest;


public class TaskTest04 extends BaseTest {
    @Test
    public void test() {
        Task04.main(null);
        String errorMessage = "Wrong result";
        assertTrue(errorMessage, outContent.toString().startsWith("6 28 496 8128"));
    }
}
