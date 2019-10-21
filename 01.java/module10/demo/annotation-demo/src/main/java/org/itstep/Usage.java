package org.itstep;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.time.Duration;
import java.time.Instant;

public class Usage {

    int field;

    void demo() {

    }

    @PerformanceTest(1000)
    public void foo() {
        //System.out.println("foo...");
        long s = 0;
        for (int i = 0; i < 10_000_000; i++) {
            s += i;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        /*
        Instant start = Instant.now();
        Usage.foo();
        Duration d = Duration.between(start, Instant.now());
        System.out.println("Method foo() executed " + d);
        */
        Usage obj = new Usage();
        Class<?> usageClass = Class.forName("org.itstep.Usage"); // obj.getClass();// Usage.class;

        Field[] fields = usageClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType().getSimpleName() + " " + f.getName());
        }

        Constructor<?> defaultConstructor = usageClass.getDeclaredConstructor();
        Method[] declaredMethods = usageClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            /*Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
            for (Annotation ann : declaredAnnotations) {
                System.out.print("Annotation: ");
                System.out.println(ann.annotationType().getSimpleName());
            }*/
            if (m.isAnnotationPresent(PerformanceTest.class)) {
                PerformanceTest performanceTest = m.getDeclaredAnnotation(PerformanceTest.class);
                int count = performanceTest.value();
                System.out.println("Repeat " + count + " count");
                int modifiers = m.getModifiers();
                long time = 0;
                for (int i = 0; i < count; i++) {
                    long start = System.currentTimeMillis();
                    if (Modifier.isStatic(modifiers)) {
                        m.invoke(null);
                    } else {
                        Object usage = defaultConstructor.newInstance();
                        m.invoke(usage);
                    }
                    time += System.currentTimeMillis() - start;
                }
                System.out.println("Average time execution for method " + m.getName() + " is " + ((double) time / count) + " ms");
//                System.out.print(Modifier.isPublic(modifiers) ? "public " : "");
//                System.out.print(Modifier.isProtected(modifiers) ? "protected " : "");
//                System.out.print(Modifier.isStatic(modifiers) ? "static " : "");
//                System.out.print(m.getReturnType().getSimpleName() +
//                        " " + m.getName() + "(");
//                Parameter[] parameters = m.getParameters();
//                for (Parameter p : parameters) {
//                    System.out.println(p.getType().getSimpleName() + " " + p.getName() + ", ");
//                }
//                System.out.println(")");
            }
        }
    }
}
