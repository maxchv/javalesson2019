package org.itstep;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * 1.	Annotations.
 * 2.	Reflection.
 * 3.	Lambda expressions.
 */

@MyAnnotation(name="test", data=5)
public class Application {

    private int field;

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {


        Class<?> cls = Application.class;
        if(cls.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = cls.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.data());
        }
        System.out.println(cls);
        Object o = cls.getDeclaredConstructor().newInstance();
        Field field = cls.getDeclaredField("field");
        System.out.println(field);
        field.set(o, 10);
        System.out.println(o);
    }

    @Override
    public String toString() {
        return "Application{" +
                "field=" + field +
                '}';
    }
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented()
@interface MyAnnotation
{
    int data () default 0;
    String name() default "test";
    String value() default "test";
}