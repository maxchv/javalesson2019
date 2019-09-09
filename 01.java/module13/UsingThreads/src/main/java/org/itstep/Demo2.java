package org.itstep;

import java.time.LocalTime;
import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) throws Exception {
        /* TODO: Создать экземпляр класса WorkedThread */
        WorkedThread workedThread = new WorkedThread();

        /* TODO: Создать экземпляр класса SleeperThread */
        SleeperThread sleeperThread = new SleeperThread();

        /* TODO: демоны??? */
        //sleeperThread.setDaemon(true);
        //workedThread.setDaemon(true);

        /* TODO: Запустить потоки */
        System.out.println("Starting threads at " + LocalTime.now());
        sleeperThread.start();
        workedThread.start();

        Thread.sleep(50L);

        /* TODO: Прервать потоки */
        sleeperThread.interrupt();
        workedThread.interrupt();

        //Thread.sleep(50L);

		/* TODO: Присоединить потоки */
        //workedThread.join();

        System.out.println(Thread.currentThread().getName() + " thread done at " + LocalTime.now());
    }

    private static class WorkedThread extends Thread {

        public WorkedThread() {
            super(WorkedThread.class.getSimpleName());
        }

        @Override
        public void run() {
            long sum = 0;
            System.out.println(getName() + " run at: " + LocalTime.now());
            for (int i = 0; i < 2_000_000_000; i++) {
                sum += i;
                /* TODO: Проверить не прерван ли поток */
                if(Thread.interrupted()) { // if implements Runnable
                //if(isInterrupted()) {    // if extends Thread
                    System.out.println("Loop interrupted at i = " + i);
                    break;
                }
            }
            System.out.println("End loop for " + getName() + " at: " + LocalTime.now());
        }
    }

    private static class SleeperThread extends Thread {

        public SleeperThread() {
            super(SleeperThread.class.getSimpleName());
        }

        @Override
        public void run() {
            System.out.println(getName() + " run at: " + LocalTime.now());
            /* TODO: Усыпить на 1000 мс */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted");
                //e.printStackTrace();
            }
            System.err.println("End " + getName() + " at: " + LocalTime.now());
        }
    }
}
