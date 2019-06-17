package org.itstep;

public class App {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.getName() = "Мурка";
        dog.info();
        //String stringDog = dog.toString();
        //System.out.println(dog);
        //animalInfo(dog);

        Animal[] zoo = new Animal[3];
        zoo[0] = new Dog();
        zoo[1] = new Cat();
        zoo[2] = new Ant();
        ((Dog)zoo[0]).bark();
        for(Animal animal: zoo) {
            animal.info();
            System.out.println();
        }

        Animal one = new Dog();
        one.age = 10;
        Animal two = new Dog();
        two.age = 10;
        if(one.equals(two)) {
            System.out.println("==");
        }
    }

    static void animalInfo(Animal animal) {
        animal.info();
    }
}

class Animal {
    protected String name;
    private boolean alive;

    int age;

    public Animal() {

    }

    public Animal(String name, boolean alive) {
        this.name = name;
        this.alive = alive;
    }

    public Animal(String name) {
        this.name = name;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void info() {
        System.out.println("It is Animal");
    }
}

class Mammal extends Animal {
    boolean isDrinkMilk;

    public Mammal() {

    }

    public Mammal(String name) {
        super(name);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("It is Mammal");
    }

    @Override
    public String toString() {
        return "It is Mammal";
    }
}

class Dog extends Mammal {

    public Dog() {
        super("Dog");
        //name = "Dog";
    }

    @Override
    public void info() {
        super.info();
        System.out.println("It is Dog");
    }

    public void bark() {
        System.out.println("Гав-гав сказал " + name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        Dog other = (Dog) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", isDrinkMilk=" + isDrinkMilk +
                '}';
    }
}

class Cat extends Mammal {
    public Cat() {
        super("Cat");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("It is Cat");
    }
}

class Insect extends Animal {
    @Override
    public void info() {
        super.info();
        System.out.println("It is Insect");
    }
}

class Ant extends Insect {
    @Override
    public void info() {
        super.info();
        System.out.println("It is Ant");
    }
}
