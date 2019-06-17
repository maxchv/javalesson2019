package ua.step.homework01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ua.step.homework1.Task02;

public class TestTask02 {

    @Test
    void test1(){
//        StringBuilder stringBuilder = new StringBuilder("ADDDDAAAAFFDSD");
//        String strRev = stringBuilder.reverse().toString();
//
//        String expeption = "DDAAAADD \nСколько елементов было удалено: 6";
//        String actual = Task02.palindrom("ADDDDAAAAFFDSD",strRev);
//
//        Assertions.assertEquals(expeption,actual);
    }
    @Test
    void test2(){
//        StringBuilder stringBuilder = new StringBuilder("АББ ББАAFDSF");
//        String strRev = stringBuilder.reverse().toString();
//
//        String expeption = "АББ ББА \nСколько елементов было удалено: 5";
//        String actual = Task02.palindrom("АББ ББАAFDSF",strRev);
//
//        Assertions.assertEquals(expeption,actual);
    }

    @Test
    @DisplayName("Test palimdrome digitals")
    void testIsPalindrome() {
//        String actual = Task02.isPalindrome("1235421");
//        String expected = "12421 2";
//        Assertions.assertEquals(actual, expected);

    }

    @Test
    @DisplayName("Test palindrome letters")
    void testPalindromeLetters() {
//        String actual = Task02.isPalindrome("henllovsollmeh");
//        String expected = "hellosolleh 3";
//        Assertions.assertEquals(actual, expected);
    }
}
