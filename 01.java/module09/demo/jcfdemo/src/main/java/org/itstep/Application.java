package org.itstep;

import java.util.*;
import java.util.function.Predicate;


public class Application {

    public static void main(String[] args) {

        // JCF
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);

        /*
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
        for(Integer item: collection) {
            System.out.print(item + " ");
        }
        System.out.println();

        collection.removeIf(new RemoveOddElement());

        for(Integer item: collection) {
            System.out.print(item + " ");
        }
        System.out.println();

        long start = System.currentTimeMillis();
        for(int i=0; i<1000_000; i++) {

        }
        System.out.println(System.currentTimeMillis() - start);

        Set<Integer> set = new HashSet<>();
        set.add(9);
        set.add(5);
        set.add(3);
        set.add(7);

        for(Integer item: set) {
            System.out.println(item);
        }

        System.out.println("ab".hashCode());

        List<Student> group = new ArrayList<>();
        group.add(new Student("Вася", 21, 10));
        group.add(new Student("Маша", 22, 3));
        group.add(new Student("Вася", 23,12));
        group.add(new Student("Вася", 23, 4));

/*        for (Student s: group) {
            if(s.mark <= 4) {
                group.remove(s);
            }
        }*/
/*
        Iterator<Student> it = group.iterator();
        while(it.hasNext()) {
            Student student = it.next();
            if(student.mark <= 4) {
                it.remove();
            }
        }

 */

//        group.removeIf(new Predicate<Student>() {
//            @Override
//            public boolean test(Student student) {
//                return student.mark <= 4;
//            }
//        });
        System.out.println(Arrays.toString(group.toArray()));

        System.out.println(countIf(group, student -> student.mark >= 10));
    }

    static int countIf(List<? extends Student> group, Predicate<? super Student> predicate) {
        int count = 0;
        for(Student student: group) {
            if(predicate.test(student)) {
                count++;
            }
        }
        return count;
    }

    static class RemoveOddElement implements Predicate<Integer> {
        @Override
        public boolean test(Integer integer) {
            return integer % 2 == 1;
        }
    }
}

class Student implements Comparable<Student> {
    static int count;
    int id;
    String name;
    int mark;
    int age;

    public Student(String name, int age, int mark) {
        this.name = name;
        this.age = age;
        this.id = ++count;
        this.mark = mark;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Student)) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        Student s = (Student) obj;
        return s.age == age && name.equals(s.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return id - o.id;
    }
}