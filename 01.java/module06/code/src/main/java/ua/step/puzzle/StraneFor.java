package ua.step.puzzle;

/**
 * 
 * Пример показывает в каком порядке и когда вызываются блоки for
 *
 */
public class StraneFor { 
    static boolean foo(char c) { 
        System.out.print(c); 
        return true; 
    } 
    public static void main(String[] args) { 
        int i = 0; 
        for (foo('A'); foo('B') && (i < 2); foo('C')) { 
            i++; 
            foo('D'); 
        } 
    } 
}