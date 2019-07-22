package org.itstep;

import java.util.List;
import java.util.Random;

public class Application {

    /**
     * В 8-й версии java появились новые функциональные интерфейсы, полный список которых
     * находится в пакете java.util.function
     * <p>
     * Среди них:
     * - Predicate<T>
     * - Supplier<T>
     * - Function<T, R>
     * - BinaryOperator<T>
     * <p>
     * Эти и другие интерфейсы широко применяются в стримах, которые также появилис в 8-й java.
     * <p>
     * Целью текущего домашнего задания является детальное знакомство с указанными интерфейсами
     * и практика работы с лямбда выражениями вместо анонимных классов.
     * <p>
     * В текущем пакете есть интерфейс ListExt, который содержит ряд методов принимающих в качестве
     * аргумента указанные выше интерфейсы, а также класс ArrayListExt, который расширяет
     * стандартный класс ArrayList и реализует интерфейс ListExt.
     * <p>
     * Необходимо:
     * 1. Внимательно прочитать комментарии к методам в интерфейсе ListExt и реализовать их
     * (по описанию) в классе ArrayListExt (статический метод generate уже реализован)
     * 2. Продемонстрировать применение всех расширенных методов класса ArrayListExt на примере
     * списка студентов. При вызове методов интерфейса ListExt нужно использовать лямбда выражения
     */
    public static void main(String[] args) {
        ListExt<Student> group = new ArrayListExt<>();
        init(group);

        // Задание 1. применить метод filter для создания списка студентов женского пола,
        // вывести полученный список на консоль

        // TODO: ваш код здесь

        // Задание 2. применить метод filter для создания списка студентов оценки которых более 9 баллов,
        // вывести полученный список на консоль

        // TODO: ваш код здесь

        // Задание 3. применить метод convert для создания списка (int) с оценками студентов
        // вывести полученный список

        // TODO: ваш код здесь

        // Задание 4. применить метод takeWhile пока у студентов оценки больше 9
        // вывести полученный список

        // TODO: ваш код здесь

        // Задание 5. применить метод dropWhile пока у студентов оценки больше 9
        // вывести полученный список

        // TODO: ваш код здесь

        Random rnd = new Random();
        List<Integer> intList = ListExt.generate(() -> rnd.nextInt(100), 10);
        // Задание 6. Для списка intList применить метод reduce найти сумму всех элементов
        // вывести полученное значение

        // TODO: ваш код здесь

        // Задание 7. для списка group применить метод max найти студента с наивысшим баллом
        // вывести студента на консоль

        // TODO: ваш код здесь

        // Задание 8. для списка group применить метод min найти студента самого младшего студента
        // вывести студента на консоль

        // TODO: ваш код здесь

        // Задание 9. для списка group применить метод anyMatch для проверки есть ли хотя бы один
        // студент, возраст которого меньше 16 лет, результат вывести на консоль

        // TODO: ваш код здесь

        // Задание 10. для списка group применить метод allMatch все ли студенты сдали сессию
        // (средний балл больше 4), результат вывести на консоль

        // TODO: ваш код здесь

        // Задание 11. для списка group применить метод noneMatch что бы проверить, что ни один
        // студент не имеет Gender.UNKNOWN, результат вывести на консоль

        // TODO: ваш код здесь


    }

    private static void init(List<? super Student> group) {
        group.add(new Student("Вася", Gender.MALE, 10, 18));
        group.add(new Student("Маша", Gender.FEMALE, 11, 21));
        group.add(new Student("Рома", Gender.MALE, 7, 17));
        group.add(new Student("Миша", Gender.MALE, 8, 16));
        group.add(new Student("Соня", Gender.FEMALE, 7, 14));
        group.add(new Student("Рита", Gender.FEMALE, 6, 11));
    }
}

enum Gender {
    MALE, FEMALE, UNKNOWN
}

class Student {
    private static int count; // глобальный счетчик объектов
    private int id; // идентификатор
    private String name; // имя
    private Gender gender; // пол
    private int mark; // средний балл
    private int age;  // возраст

    public Student(String name, Gender gender, int mark, int age) {
        this.id = ++count;
        this.name = name;
        this.gender = gender;
        this.mark = mark;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", mark=" + mark +
                ", age=" + age +
                '}';
    }
}