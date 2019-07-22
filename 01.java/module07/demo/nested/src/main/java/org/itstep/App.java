package org.itstep;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Man man = new Man("JonSnow", 21);
        System.out.println("Man.getHatCount() = " + Man.getHatCount());

        man.wearHat("red");
        System.out.println("Man.getHatCount() = " + Man.getHatCount());
        man.wearHat("green");

        System.out.println("Man.getHatCount() = " + Man.getHatCount());

        System.out.println(man);

        Man.Hat hat = man.getHat();

        // создан экземпляр вложенного (статического) класса
        Man.Hat newHat = new Man.Hat("blue");

        Man.Hart hart = man.new Hart(60);

        man.buyHat(newHat);
        System.out.println(man);

        Man[] group = {
            new Man("Mary", 18),
            new Man("David", 28),
            new Man("Viktor", 21),
            new Man("Rita", 20),
        };

        // Локальный класс
        class CompareByAgeAsc extends Comparator {
            boolean compare(Object o1, Object o2) {
                if(o1 instanceof Man && o2 instanceof Man) {
                    return (((Man)o1).age > ((Man) o2).age);
                }
                return false;
            }
        }

        Comparator comparator = new CompareByAgeAsc();
        sort(group, comparator);
        System.out.println(Arrays.toString(group));

        Comparator comparator1 = new Comparator() {
            boolean compare(Object o1, Object o2) {
                if(o1 instanceof Man && o2 instanceof Man) {
                    return (((Man)o1).age < ((Man) o2).age);
                }
                return false;
            }
        };
        sort(group, comparator1);
        System.out.println(Arrays.toString(group));

        class CompareMan implements java.util.Comparator {

            public int compare(Object o1, Object o2) {
                if(o1 instanceof Man && o2 instanceof Man) {
                    return ((Man)o1).name.compareTo(((Man) o2).name);
                }
                return 1;
            }
        }

        java.util.Comparator cmp = new CompareMan();
        Arrays.sort(group, cmp);

        System.out.println(Arrays.toString(group));
    }

    static void sort(Object[] mans, Comparator comparator) {
        for(int i=0; i<mans.length; i++) {
            for(int j=0; j<mans.length-1; j++) {
//                if(mans[j].name.compareTo(mans[j + 1].name) < 0) {
                if(comparator.compare(mans[j], mans[j + 1])) {
                    Object tmp = mans[j];
                    mans[j] = mans[j+1];
                    mans[j+1] = tmp;
                }
            }
        }
    }

    static abstract class Comparator {
        abstract boolean compare(Object o1, Object o2);
    }

    private static boolean cmp(Object first, Object second) {
        if(first instanceof Man && second instanceof Man) {
            return (((Man)first).age > ((Man) second).age);
        }
        return false;
    }
}

class Man {

    private int rate;

    // вложенный статический класс
    static class Hat {
        private static int hatCount;
        private String color;

        Hat(String color) {
            this.color = color;
            hatCount++;
        }

        @Override
        public String toString() {
            return color + " hat";
        }
    }

    // внутренний (не статический) класс
    class Hart {

        public Hart(int rate) {
            Man.this.rate = rate;
        }

        public void stress() {
            rate = 120;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            Man.this.rate = rate;
        }

        @Override
        public String toString() {
            return "Hart{" +
                    "rate=" + rate +
                    '}';
        }
    }

    Hat hat;
    Hart hart;
    String name;
    int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
        this.hart = new Hart(60);
    }

    public Hat getHat() {
        return hat;
    }

    public static int getHatCount() {
        return Hat.hatCount;
    }

    public void wearHat(String color) {
        hat = new Hat(color);
    }

    public void buyHat(Hat hat) {
        this.hat = hat;
    }

    @Override
    public String toString() {
        return  "\n" + name + " " + age + " year old wear " + hat + " " + rate;
    }
}
