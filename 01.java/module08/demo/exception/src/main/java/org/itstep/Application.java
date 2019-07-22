package org.itstep;

public class Application {
    public static void main(String[] args) {
        System.out.println("Start program");
        try {
            int result = add("123");
            System.out.println("result: " + result);
        } catch (NoComaFoundException e) {
            System.err.println("Не найдена запятая: " + e.getMessage());
        } catch (NullOrEmptyStringException e) {
            System.err.println("Пустая строка: " + e.getMessage());
        }

        System.out.println("End of program");
    }

    /**
     * Возвращает сумму
     * @param args - непустая строка с числами разделенными запятой
     * @return
     */
    static int add(String args) throws NullOrEmptyStringException, NoComaFoundException {
        if(args == null || args.isEmpty()) {
            throw new NullOrEmptyStringException("Строка не должна быть пустой");
        }
        if(args.indexOf(",") < 0) {
            throw new NoComaFoundException("Должна быть хотя бы одна запятая во входной строке");
        }
        return 0;
    }
}

class NullOrEmptyStringException extends Exception {
    public NullOrEmptyStringException(String message) {
        super(message);
    }
}

class NoComaFoundException extends Exception {
    public NoComaFoundException(String message) {
        super(message);
    }
}


