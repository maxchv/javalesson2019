package org.itstep.hw04;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Task01 {
    /**
     * Класс QuickSort предназначен для быстрой сортировки массивов
     * Необходимо применить ForkJoinPool для ускорения сортировки массивов.
     * Оценить эффективность распараллеливания данной задачи.
     * Сравнить сортировку без распараллеливания с параллелной реализвацией
     * через ForkJoinPool и с параллельной сортировкой через стримы.
     * @param args
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        Integer[] data = rnd.ints()
                            .limit(10_000_000).boxed().toArray(Integer[]::new);
        QuickSort<Integer> quickSort = new QuickSort<>(data);
        Instant start = Instant.now();
        quickSort.sort();
        Duration duration = Duration.between(start, Instant.now());
        System.out.println("duration = " + duration.toMillis());
    }
}

class QuickSort<T extends Comparable> {

    private final T[] data;
    private int left;
    private int right;

    public QuickSort(T[] data) {
        this.data = data;
        left = 0;
        right = data.length - 1;
    }

    public QuickSort(T[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T[] getData() {
        return data;
    }

    public void sort() {
        if (left < right) {
            int partitionIndex = partition(data, left, right);

            new QuickSort(data, left, partitionIndex - 1).sort();
            new QuickSort(data, partitionIndex + 1, right).sort();
        }
    }

    private int partition(T data[], int left, int right) {
        T pivot = data[right];
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (data[j].compareTo(pivot) <= 0) {
                i++;

                T swapTemp = data[i];
                data[i] = data[j];
                data[j] = swapTemp;
            }
        }

        T swapTemp = data[i + 1];
        data[i + 1] = data[right];
        data[right] = swapTemp;

        return i + 1;
    }
}
