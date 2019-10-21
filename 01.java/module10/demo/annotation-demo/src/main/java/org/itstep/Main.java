package org.itstep;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@AnnotationDemo("Value data")
public class Main {

    @AnnotationDemo(value = "data", data="data")
    int data;

    //@AnnotationDemo
    public static void main(/*@AnnotationDemo*/ String[] args) {
        // Java annotation since 1.5 JDK

        Person p = new Person(1, "Вася", "Пупкин", 21, "Студент");
        System.out.println(p);


    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.FIELD})
@interface AnnotationDemo {
    String value();
    String data() default "Some data";
}