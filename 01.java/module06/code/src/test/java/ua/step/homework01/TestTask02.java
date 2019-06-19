package ua.step.homework01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.step.homework1.Task02;

public class TestTask02 {

    @Test
    void test1(){
        String expeption = "DDAAAADD";
        String actual = Task02.makePalindrome("ADDDDAAAAFFDSD");
        Assertions.assertEquals(expeption,actual);
    }

    @Test
    void test2(){
        String expeption = "АББ ББА";
        String actual = Task02.makePalindrome("АББ ББАAFDSF");
        Assertions.assertEquals(expeption,actual);
    }

    @Test
    void testIsPalindrome() {
        String actual = Task02.makePalindrome("1235421");
        String expected = "12421";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void testPalindromeLetters() {
        String actual = Task02.makePalindrome("henllovsollmeh");
        String expected = "hellosolleh";
        Assertions.assertEquals(actual, expected);
    }
}
