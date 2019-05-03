package ua.step.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask07 extends BaseTest {

    private final String input;
    private final String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"a", "латиница"},
                        {"b", "латиница"},
                        {"c", "латиница"},
                        {"d", "латиница"},
                        {"e", "латиница"},
                        {"f", "латиница"},
                        {"g", "латиница"},
                        {"h", "латиница"},
                        {"i", "латиница"},
                        {"z", "латиница"},
                        {"A", "латиница"},
                        {"B", "латиница"},
                        {"C", "латиница"},
                        {"D", "латиница"},
                        {"E", "латиница"},
                        {"F", "латиница"},
                        {"G", "латиница"},
                        {"H", "латиница"},
                        {"I", "латиница"},
                        {"Z", "латиница"},
                        {"а", "кирилица"},
                        {"б", "кирилица"},
                        {"в", "кирилица"},
                        {"г", "кирилица"},
                        {"д", "кирилица"},
                        {"ж", "кирилица"},
                        {"з", "кирилица"},
                        {"я", "кирилица"},
                        {"А", "кирилица"},
                        {"Б", "кирилица"},
                        {"В", "кирилица"},
                        {"Г", "кирилица"},
                        {"Д", "кирилица"},
                        {"Ж", "кирилица"},
                        {"З", "кирилица"},
                        {"Я", "кирилица"},
                        {"0", "цифра"},
                        {"1", "цифра"},
                        {"2", "цифра"},
                        {"3", "цифра"},
                        {"4", "цифра"},
                        {"5", "цифра"},
                        {"6", "цифра"},
                        {"7", "цифра"},
                        {"8", "цифра"},
                        {"9", "цифра"},
                }
        );
    }

    public TestTask07(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpInput() {
        System.setIn(new ByteArrayInputStream(this.input.getBytes()));
    }

    @Test
    public void test() throws IOException {
        Task07.main(null);
        String out = outContent.toString().split("\\n")[1];
        Assert.assertEquals(this.expected, out.toLowerCase().trim());
    }
}
