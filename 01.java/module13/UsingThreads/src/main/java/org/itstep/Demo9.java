package org.itstep;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Demo9 {
    private static final long N = 1000_000;
    private static final int NUM_THREADS = 10;

    static class RecursiveSumOfN extends RecursiveTask<Long> {
        long from, to;

        public RecursiveSumOfN(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long compute() {
            long localSum = 0;
            if ((to - from) < N / NUM_THREADS) {
                for (long i = from; i <= to; i++) {
                    localSum += i;
                }
                System.out.printf("\tSum of value range %d to %d is %d %n", from, to, localSum);
            } else {
                long mid = (to + from) / 2;
                RecursiveSumOfN left = new RecursiveSumOfN(from, mid);
                left.fork();
                RecursiveSumOfN right = new RecursiveSumOfN(mid + 1, to);
                long result = right.compute();
                Long leftResult = left.join();
                localSum = result + leftResult;
                System.out.println("Thread: " + Thread.currentThread().getName());
                System.out.printf("\tSum left result from %d to %d and right result from %d to %d = %d %n",
                        from, mid, mid + 1, to, localSum);
            }

            return localSum;

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        RecursiveSumOfN task = new RecursiveSumOfN(0, N);
        forkJoinPool.execute(task);

        Long computedSum = task.get();

        long formulaSum = (N * (N + 1)) / 2;
        System.out.printf("Sum for range 1..%d; computed sum = %d, " +
                "formula sum = %d %n", N, computedSum, formulaSum);

        long sum = LongStream.rangeClosed(0, N)
                .parallel()
                .sum();
        System.out.printf("Parallel computation: %d %n", sum);

        Random rnd = new Random(10);
        Random rnd2 = new Random(10);

        IntStream rndNumbersStream = rnd.ints().limit(N);
        IntStream rndNumbersStream2 = rnd2.ints().limit(N);

        Instant start = Instant.now(); // момент времени
        long count = rndNumbersStream.sorted().count();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end); // длительность
        System.out.println("Sequence sort: " + duration);

        start = Instant.now(); // момент времени
        count = rndNumbersStream2.parallel().sorted().count();
        end = Instant.now();
        duration = Duration.between(start, end); // длительность
        System.out.println("Parallel sort: " + duration);
    }
}
