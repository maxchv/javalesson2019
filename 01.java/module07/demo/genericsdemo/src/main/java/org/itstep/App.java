package org.itstep;

import java.rmi.server.UID;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Student masha = new Student("Маша", Gender.FEMALE);
        Gender gender = Gender.FEMALE;
        System.out.println(gender.toNumber());
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Имя? ");
//        String name = scanner.next();
//        System.out.print("Пол [");
//        for(Gender gender: Gender.values()) {
//            System.out.print(gender + "|");
//        }
//        System.out.print("]? ");
//        String gender = scanner.next();
//        Student vasja = new Student(name, Gender.valueOf(gender));
        //Student rita = new Student("Рита", Gender.FEMALE);

        Group group = new Group();
        group.addHead(masha);
        //group.addHead(vasja);
        System.out.println(group);
        Group group2 = new Group();

        MathOperation addObj = new MathOperation() {
            int count;

            {
                count = 0;
            }

            public int binOperation(int a, int b) {
                count++;
                return a + b;
            }
        };
    }
}

interface MathOperation {
    int binOperation(int a, int b);
}

class Identity {
    String getUid() {
        return "test";
    }
}

class Group {
    static String id;

    static {
        id = new Identity().getUid();
    }

    Student head;
    int size;

    static {
        System.out.println("Static init block");
    }

    {
        head = null;
        System.out.println("Init block #1");
    }

    public Group() {
        System.out.println("Constructor group");
    }

    {
        size = 0;
        System.out.println("Init block #2");
    }

    void addHead(Student student) {
        student.next = head;
        head = student;
        size++;
    }

    void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    int count() {
        return size;
    }

    @Override
    public String toString() {
        Student cur = head;
        StringBuilder res = new StringBuilder();
        while (cur != null) {
            res.append(cur).append("\n");
            cur = cur.next;
        }
        return res.toString();
    }
}

enum Gender {
    MALE(1),
    FEMALE(0),
    UNKNOWN(100);

    final int num;

    Gender(int num) {
        this.num = num;
    }

    int toNumber() {
        return num;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "num=" + num +
                '}';
    }
}

class Student {
    String name;
    Student next;
    Gender gender;

    public Student(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
