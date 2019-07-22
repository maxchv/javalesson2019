package org.itstep;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Generics {
    public static void main(String[] args) {
        Tea tea = new Tea("Бразильский", "Красный");
        Jar<Tea> teaJar = new Jar<>(tea);
        Jar<Nails> nailsJar = new Jar<Nails>(new Nails());

        //jar.setValue(new Nails());

        Drink value = teaJar.getValue();
        value.drink();

        Jar<Coffee> coffeeJar = new Jar<>(new Coffee("Капучино"));


        Jar<Map<String, List<Set<String>>>> jar7 = new Jar<>(null);

        printJar(teaJar);
        printJar(nailsJar);
        printJar(coffeeJar);
        printJar(jar7);

        //drinkFromJar(nailsJar);
        drinkFromJar(teaJar);
        drinkFromJar(coffeeJar);

        addTeaToJar(teaJar);

        //String add1 = add("one", "two");
        Integer add = add(1, 2);
        System.out.println(add);
    }

    static <T extends Number> T add(T a, T b) {
        //return a + b;
        T result = null;
        if(a.getClass().equals(Integer.class)){
            result = (T) Integer.valueOf(a.intValue() + b.intValue());
        }
        return result;
    }

    private static void addTeaToJar(Jar<? super Tea> teaJar) {
        teaJar.setValue(new Carkade("", ""));
    }

    static void drinkFromJar(Jar<? extends Drink> jar) {
        Drink value = jar.getValue();
        value.drink();
        jar.setValue(null);
    }

    static void printJar(Jar<?> jar) {
        Object value = jar.getValue();
    }
}

class Nails {

}

abstract class Drink {
    abstract void drink();
}

class Tea extends Drink {
    String name;
    String color;

    public Tea(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void drink() {
        System.out.println("Вкусный " + name + " чайок");
    }

    @Override
    public String toString() {
        return "Tea{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class Carkade extends Tea {

    public Carkade(String name, String color) {
        super(name, color);
    }
}

class Coffee extends Drink {
    String name;

    public Coffee(String name) {
        this.name = name;
    }

    void drink() {
        System.out.println("Вкусный " + name + " кофе");
    }
}

class Jar<T> {
    //static T t;
    T value;

    public Jar(T value) {
        T[] arr;// = new T[10];
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}