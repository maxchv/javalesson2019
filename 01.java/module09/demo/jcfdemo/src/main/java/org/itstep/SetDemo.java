package org.itstep;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        Random rnd = new Random();
        for(int i=0; i<10; i++) {
            set.add(rnd.nextInt(100));
        }

        System.out.println(Arrays.toString(set.toArray()));

        Set<Student> group = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        group.add(new Student("Вася", 21, 10));
        group.add(new Student("Маша", 22, 23));
        group.add(new Student("Вася", 23, 23));
        group.add(new Student("Вася", 23, 1));

        for (Student s: group) {
            System.out.println(s);
        }
    }
}
