package org.itstep;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamsDemo {

    static <T> void consumer(T inp) {
        System.out.println(inp);
    }

    static void directStream() {
        System.out.format("Stream%n------%n");
        int[] arr = {1, 2, 3, 4, 5, 5, 2, 1};
        String str = "Hello";
//        for (int item : arr) {
//            System.out.println("item = " + item);
//        }
        Arrays.stream(arr).forEach(item -> System.out.println("item = " + item));

//        IntStream.of(1,2,34);
//        LongStream;
//        DoubleStream

    }

    static List<String> stringCollection = new ArrayList<>();

    static {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    static void collectionStream() {
        System.out.format("Collection Stream%n------%n");
        stringCollection.forEach(item -> System.out.println(item));
//        for (String item : stringCollection) {
//            System.out.println("item = " + item);
//        }
      
    }

    private static void filterExample() {
        System.out.format("Filter%n------%n");
        // print string starts with 'a'
        stringCollection.stream()
                .filter(item -> item.startsWith("a"))
                .forEach(item -> System.out.println("item = " + item));
//        List<String> res = new ArrayList<>();
//        for (String item : stringCollection) {
//            if (item.startsWith("a")) {
//                res.add(item);
//            }
//        }
//        for (String item : res) {
//            System.out.println("item = " + item);
//        }

     
    }

    private static void sortExample() {
        System.out.format("%nSorted%n------%n");
        // sort string starts with 'a' and print
        stringCollection.stream()
                .filter(item -> item.startsWith("a"))
                .sorted((a, b) -> b.compareTo(a))
                .forEach(item -> System.out.println("item = " + item));
//        List<String> res = new ArrayList<>();
//        for (String item : stringCollection) {
//            if (item.startsWith("a")) {
//                res.add(item);
//            }
//        }
//        res.sort((a, b) -> a.compareTo(b));
//        for (String item : res) {
//            System.out.println("item = " + item);
//        }
       
    }

    private static List<Integer> mapExample() {
        System.out.format("%nMap%n---%n");
        // find string length 4 chars, get last char, convert to int, get list
//        List<Integer> intCollection = new ArrayList<>();
//
//        for (String item : stringCollection) {
//            if (item.length() == 4) {
//                intCollection.add(Integer.valueOf(item.substring(3)));
//            }
//        }

        List<Integer> numbers = stringCollection.stream()
                .filter(item -> item.length() == 4)
                .map(item -> Integer.valueOf(item.substring(3)))
                .peek(item -> System.out.println(item))
                .collect(Collectors.toList());

        Map<String, Integer> collect = stringCollection.stream()
                .filter(item -> item.length() == 4)
                .collect(Collectors.toMap(item -> item, item -> Integer.valueOf(item.substring(3))));

        return numbers;
    }

    private static void distinctExample(List<? extends Integer> intCollection) {
        System.out.format("%nDistinct%n--------%n");
        intCollection.stream()
                     .distinct()
                     .sorted()
                     .forEach(item -> System.out.println(item));
//        List<Integer> distinctList = new ArrayList<>();
//        for (Integer item : intCollection) {
//            if (!distinctList.contains(item)) {
//                distinctList.add(item);
//            }
//        }
        
    }

    private static void matchExample() {
        System.out.format("%nMatch%n-----%n");

//        for (String item : stringCollection) {
//            if (item.startsWith("a")) {
//                isAnyWordStartA = true;
//                break;
//            }
//        }
        boolean isAnyWordStartA = stringCollection.stream().anyMatch(item -> item.startsWith("a"));
        System.out.println("isAnyWordStartA: " + isAnyWordStartA);


//        for (String item : stringCollection) {
//            if (!item.startsWith("a")) {
//                isAllWordStartA = false;
//                break;
//            }
//        }
        boolean isAllWordStartA = stringCollection.stream().allMatch(item -> item.startsWith("a"));
        System.out.println("isAllWordStartA: " + isAllWordStartA);


        boolean isNoneWordStartA = stringCollection.stream().noneMatch(item -> item.startsWith("a"));;
        System.out.println("isNoneWordStartA: " + isNoneWordStartA);
    }

    private static void minMaxExample(List<Integer> intCollection) {
        System.out.format("%nMin/Max%n-------%n");

//        Integer maxInt = intCollection.get(0);
//        for(Integer item: intCollection) {
//            if(Integer.compare(item, maxInt) > 0) {
//                maxInt = item;
//            }
//        }
        Optional<Integer> max = intCollection.stream().filter(item -> item > 0).max((a, b) -> a - b);
        Integer integer = max.orElse(-1);
        System.out.println(integer);
//        if(max.isPresent()) {
//            System.out.println(max.get());
//        }

//        System.out.println("max: " + maxInt);

//        Integer minInt = intCollection.get(0);
//        for(Integer item: intCollection) {
//            if(Integer.compare(item, minInt) < 0) {
//                minInt = item;
//            }
//        }

//       System.out.println("min: " + minInt);
    }

    private static void countExample(List<Integer> intCollection) {
        System.out.format("%nCount%n-----%n");
        // count only even number

//        for(Integer item: intCollection) {
//            if(item % 2 == 0) {
//                countEven++;
//            }
//        }

//        System.out.println("count: " + countEven);
    }

    private static void averageExample(List<Integer> intCollection) {
        System.out.format("%nAverage%n-------%n");
//        double average = 0;
//        for(Integer item: intCollection) {
//            average += item;
//        }
//        average /= intCollection.size();
        intCollection.stream()
                .mapToInt(i -> i)
                .average()
                .ifPresent(avg -> System.out.println(avg));

		// summaryStatistics
        IntSummaryStatistics intSummaryStatistics = intCollection.stream()
                .mapToInt(i -> i)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);
    }

    private static void reduceExample(List<Integer> intCollection) {
        System.out.format("%nReduce%n-------%n");
//        int prod = 1;
//        for(Integer item: intCollection) {
//            prod = prod * item;
//        }
        int prod = intCollection.stream().reduce(1, (acc, item) -> acc * item);
        System.out.println("prod: " + prod);
    }

    public static void main(String[] args) {

        directStream();

        collectionStream();

        // --- Intermediate operations ---
        // Filter
        filterExample();

        // Sorted
        sortExample();

        // Map
        List<Integer> intCollection = mapExample();

        // Distinct
        distinctExample(intCollection);

        // --- Terminal operations ---
        // Match
        matchExample();

        // Max, Min
        minMaxExample(intCollection);

        // Count
        countExample(intCollection);

        // Average	(terminal operation)
        averageExample(intCollection);

        // Reduce (terminal operation)
        reduceExample(intCollection);

        // Parallel Streams
        parallelStreamsExample();
    }

    private static void parallelStreamsExample() {
        int max = 10_000_000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        System.out.format("%nSequence%n-------%n");
        Instant start = Instant.now();
        System.out.println("start = " + start);
        values.stream()
                .sorted()
                .count();
        Instant end = Instant.now();
        System.out.println("end = " + end);
        Duration seq = Duration.between(start, end);
        System.out.println("seq: " + seq);

        System.out.format("%nParallel%n-------%n");
        start = Instant.now();
        System.out.println("start = " + start);
        values.parallelStream()
                .sorted()
                .count();
        System.out.println("end = " + end);
        Duration par = Duration.between(start, end);
        System.out.println("\npar: " + par);
        //System.out.println("seq/par: " + ((double) seq / par));
    }
}
