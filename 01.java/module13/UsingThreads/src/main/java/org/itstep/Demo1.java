package org.itstep;

import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Random;

public class Demo1 {

    /* TODO: Реализация интерфейса Runnable */
    static class RunnableDemo implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End of thread " + Thread.currentThread().getName());
        }
    }


    /* TODO: Наследование класса Thread */
    static class ThreadDemo extends Thread {

        public ThreadDemo(String name) {
            super(name);
        }

        @Override
        public void run() {
            for(int i=0; i<10; i++) {
                System.out.println("i = " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("End thread " + Thread.currentThread().getName() + " at " + LocalDateTime.now());
        }
    }


    public static void main(String[] args) throws InterruptedException {


        /* TODO: Анонимный класс реализующий интерфейс Runnable */
//        Thread runnableDemo = new Thread(new RunnableDemo(), "RunnableDemo");
//        runnableDemo.start();

        /* TODO: Анонимный класс налседующий класс Thread */
//        ThreadDemo threadDemo = new ThreadDemo("ThreadDemo");
//        threadDemo.start();

//        String folder = chooseFolder();
//        System.out.println(folder);

        practice();

        System.out.println("End " + Thread.currentThread().getName() + " at " + LocalDateTime.now());
    }

    private static void practice() throws InterruptedException {
        Random rnd  = new Random();
        int[] arr = rnd.ints(50_000_000).toArray();
        final long[] parts = new long[2];
        Instant start = Instant.now();
        Thread t = new Thread(() -> {
            parts[0] = summ(arr, arr.length/2, arr.length);
        });
        t.start();
        parts[1] = summ(arr, 0, arr.length/2);
        t.join();
        Duration duration = Duration.between(start, Instant.now());
        System.out.println(duration.toMillis());
    }

    private static long summ(int[] arr, int from, int to) {
        long s = 0;
        for(int i=from; i<to; i++) {
            s += arr[i];
        }
        return s;
    }

    private static String chooseFolder() {
        JFileChooser chooser = new JFileChooser(); // Создаем диалог
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // отображать только директории
        int returnVal = chooser.showOpenDialog(null); // показать диалог открытия файла
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getName(); // здесь находится имя выбранной папки
        }
        return null;
    }
}
