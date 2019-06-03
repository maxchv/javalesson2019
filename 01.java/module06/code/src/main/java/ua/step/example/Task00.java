package ua.step.example;

/**
 * Объявление методов в теле классе
 */
public class Task00
{
    // объявление метода с именем hello
	static void hello(){
    	System.out.println("Hello");
    }

	public static void main(String[] args)
    {
		hello(); // вызов метода
    }
	
	// объявление метода с именем goodBay
	static void goodBay(){
    	System.out.println("Good bay ");
    }
} 
// FIXME измените код в методе main, чтобы программа вывела 
// Good bay
// Hello
// Good bay