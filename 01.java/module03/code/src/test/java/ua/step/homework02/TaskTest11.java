package ua.step.homework02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ua.step.BaseTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTest11 extends BaseTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2019","      January                   February                   March\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "    1  2  3  4  5  6                   1  2  3                   1  2  3\n" +
                        " 7  8  9 10 11 12 13       4  5  6  7  8  9 10       4  5  6  7  8  9 10\n" +
                        "14 15 16 17 18 19 20      11 12 13 14 15 16 17      11 12 13 14 15 16 17\n" +
                        "21 22 23 24 25 26 27      18 19 20 21 22 23 24      18 19 20 21 22 23 24\n" +
                        "28 29 30 31               25 26 27 28               25 26 27 28 29 30 31\n" +
                        "\n" +
                        "       April                      May                       June\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        " 1  2  3  4  5  6  7             1  2  3  4  5                      1  2\n" +
                        " 8  9 10 11 12 13 14       6  7  8  9 10 11 12       3  4  5  6  7  8  9\n" +
                        "15 16 17 18 19 20 21      13 14 15 16 17 18 19      10 11 12 13 14 15 16\n" +
                        "22 23 24 25 26 27 28      20 21 22 23 24 25 26      17 18 19 20 21 22 23\n" +
                        "29 30                     27 28 29 30 31            24 25 26 27 28 29 30\n" +
                        "\n" +
                        "        July                     August                  September\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        " 1  2  3  4  5  6  7                1  2  3  4                         1\n" +
                        " 8  9 10 11 12 13 14       5  6  7  8  9 10 11       2  3  4  5  6  7  8\n" +
                        "15 16 17 18 19 20 21      12 13 14 15 16 17 18       9 10 11 12 13 14 15\n" +
                        "22 23 24 25 26 27 28      19 20 21 22 23 24 25      16 17 18 19 20 21 22\n" +
                        "29 30 31                  26 27 28 29 30 31         23 24 25 26 27 28 29\n" +
                        "                                                    30\n" +
                        "\n" +
                        "      October                   November                  December\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "    1  2  3  4  5  6                   1  2  3                         1\n" +
                        " 7  8  9 10 11 12 13       4  5  6  7  8  9 10       2  3  4  5  6  7  8\n" +
                        "14 15 16 17 18 19 20      11 12 13 14 15 16 17       9 10 11 12 13 14 15\n" +
                        "21 22 23 24 25 26 27      18 19 20 21 22 23 24      16 17 18 19 20 21 22\n" +
                        "28 29 30 31               25 26 27 28 29 30         23 24 25 26 27 28 29\n" +
                        "                                                    30 31\n"},
                {"2020","      January                   February                   March\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "       1  2  3  4  5                      1  2                         1\n" +
                        " 6  7  8  9 10 11 12       3  4  5  6  7  8  9       2  3  4  5  6  7  8\n" +
                        "13 14 15 16 17 18 19      10 11 12 13 14 15 16       9 10 11 12 13 14 15\n" +
                        "20 21 22 23 24 25 26      17 18 19 20 21 22 23      16 17 18 19 20 21 22\n" +
                        "27 28 29 30 31            24 25 26 27 28 29         23 24 25 26 27 28 29\n" +
                        "                                                    30 31\n" +
                        "\n" +
                        "       April                      May                       June\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "       1  2  3  4  5                   1  2  3       1  2  3  4  5  6  7\n" +
                        " 6  7  8  9 10 11 12       4  5  6  7  8  9 10       8  9 10 11 12 13 14\n" +
                        "13 14 15 16 17 18 19      11 12 13 14 15 16 17      15 16 17 18 19 20 21\n" +
                        "20 21 22 23 24 25 26      18 19 20 21 22 23 24      22 23 24 25 26 27 28\n" +
                        "27 28 29 30               25 26 27 28 29 30 31      29 30\n" +
                        "\n" +
                        "        July                     August                  September\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "       1  2  3  4  5                      1  2          1  2  3  4  5  6\n" +
                        " 6  7  8  9 10 11 12       3  4  5  6  7  8  9       7  8  9 10 11 12 13\n" +
                        "13 14 15 16 17 18 19      10 11 12 13 14 15 16      14 15 16 17 18 19 20\n" +
                        "20 21 22 23 24 25 26      17 18 19 20 21 22 23      21 22 23 24 25 26 27\n" +
                        "27 28 29 30 31            24 25 26 27 28 29 30      28 29 30\n" +
                        "                          31\n" +
                        "\n" +
                        "      October                   November                  December\n" +
                        "Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su      Mo Tu We Th Fr Sa Su\n" +
                        "          1  2  3  4                         1          1  2  3  4  5  6\n" +
                        " 5  6  7  8  9 10 11       2  3  4  5  6  7  8       7  8  9 10 11 12 13\n" +
                        "12 13 14 15 16 17 18       9 10 11 12 13 14 15      14 15 16 17 18 19 20\n" +
                        "19 20 21 22 23 24 25      16 17 18 19 20 21 22      21 22 23 24 25 26 27\n" +
                        "26 27 28 29 30 31         23 24 25 26 27 28 29      28 29 30 31\n" +
                        "                          30\n"},
               });
    }

    private final String input;
    private final String expected;

    public TaskTest11(String input, String expected) {
        super(null, Task11.class);
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(testClass == null) return;
        String errorMessage = String.format("Wrong draw number: %s", input);
        super.systemInputTest(input, expected, errorMessage);
    }
}
