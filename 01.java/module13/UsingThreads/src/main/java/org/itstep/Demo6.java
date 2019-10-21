package org.itstep;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Demo6 {

    //final static Semaphore semaphore = new Semaphore(4);
    //final static CountDownLatch countDownLatch = new CountDownLatch(4);
    final static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    final static Random random = new Random();

    static class Player implements Callable<Void> {

        private final String name;

        public Player(String name) {
            this.name = name;
        }

        @Override
        public Void call() throws Exception {
            Thread.sleep(random.nextInt(3000) + 1000);
            ////System.out.println("Count: " + countDownLatch.getCount());
            System.out.println("Player " + name + " is ready");
            cyclicBarrier.await();
            ////countDownLatch.countDown();
            //semaphore.acquire();
            ////countDownLatch.await();
            System.out.println(name + " is starting");
            Thread.sleep(random.nextInt(3000) + 1000);
            //semaphore.release();
            cyclicBarrier.reset();
            System.out.println(name + " end");

            return null;
        }
    }

    // # Synchronization demo
    // Semaphore
    // CountDownLatch
    // CyclicBarrier
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.invokeAll(
                Arrays.asList(
                        new Player("one"),
                        new Player("two"),
                        new Player("three"),
                        new Player("four"),
                        new Player("five"),
                        new Player("six"),
                        new Player("seven")
                        //new Player("eight")
                )
        );
        //executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
