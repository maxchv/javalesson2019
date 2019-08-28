package org.itstep;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class Application {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = inventory
                                        .stream()
                                        .filter(apple -> "green".equals(apple.color))
                                        .collect(Collectors.toList());
//        List<Apple> greenApples = new ArrayList<>();
//        for(Apple apple: inventory) {
//            if("green".equals(apple.color)){
//                greenApples.add(apple);
//            }
//        }
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = null;
        System.out.println(heavyApples);

        System.out.println(sum(1, 2, 3, 4, 5));

        Stream.of(1,2,3,4,5)
               .filter(item -> item % 2 == 1)
               .limit(2)
               .peek(new Consumer<Integer>() {
                   @Override
                   public void accept(Integer integer) {
                       System.out.println(integer);
                   }
               })
              .count()
        ;

        IntStream.rangeClosed(1,5) // [1, 5) - range
                                   // [1, 5] - rangeClose
                .forEach(item -> System.out.println("range: " + item));
        Random rnd = new Random();
        rnd.doubles().limit(10).forEach(item -> System.out.println("rnd: " + item));

        Stream.generate(() -> rnd.nextInt(100))
                .limit(5)
                .forEach(item -> System.out.println("rndInt: " + item));
    }

    public static int sum(int... args) { // vararg
        return Arrays.stream(args).sum();
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
