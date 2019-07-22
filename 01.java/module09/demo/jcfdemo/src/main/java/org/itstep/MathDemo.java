package org.itstep;

public class MathDemo {
    public static void main(String[] args) {
        try {
            System.out.println(div(10,2));
            System.out.println(div(10, 0));
            System.out.println(div(0, 0));
        } catch (DivByZeroException e) {
            //e.printStackTrace();
            System.err.println("Ошибка");
        }
        System.out.println("End of program");
    }

    static double div(int a, int b) throws DivByZeroException {
        if(b == 0) {
            throw new DivByZeroException("/ by zero");
        }
        return a/b;
    }
}

class DivByZeroException extends RuntimeException {
    public DivByZeroException(String message) {
        super(message);
    }
}