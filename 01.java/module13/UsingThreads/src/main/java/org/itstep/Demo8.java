package org.itstep;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by max on 01.10.2017.
 */
public class Demo8 {
    // TODO: implements interface Callable instead Runnable
    public static class Worker implements Callable<String> {

        final String name;


        public Worker(String string) {
            name = string;
        }

        @Override
        public String call() {
            long sleepTime = (long) (Math.random()*10000L);
            System.out.println(name + " started, going to sleep for " + sleepTime + " seconds");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " finished");
            // FIXME: return name???
             return name;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO: ExecutorService, Executors
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        System.out.println("Submit worker 1");
        Future<?> future1 = executorService.submit(() -> {
            System.out.println("First work " + Thread.currentThread().getName()+  "  at " + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End work " +Thread.currentThread().getName()+  "  at " + LocalDateTime.now());
            return Thread.currentThread().getName();
        });

        executorService.submit(() -> {
            System.out.println("Second work " + Thread.currentThread().getName()+  "  at " + LocalDateTime.now());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End work " +Thread.currentThread().getName()+  "  at " + LocalDateTime.now());
            return Thread.currentThread().getName();
        });

        System.out.println("Submit worker 1");
        //future1.cancel(true);
        System.out.println("Result of worker 1: " + future1.get());
        System.out.println("Result of worker 2: ");
        System.out.println("---------------------");

        System.out.println("Submit workers using invoke All");

        List<Worker> workerList =  Arrays.asList(
                        new Worker("Worker 3"),
                        new Worker("Worker 4"),
                        new Worker("Worker 5")
        );

        System.out.println("Exited invokeAll");

        executorService.invokeAll(workerList);
        // for all tasks {
            System.out.println("Result from worker: ");
        //}

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
