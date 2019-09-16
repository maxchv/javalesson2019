package org.itstep;

public class Demo9 {
    private static long N = 1000_000;
    private static final int NUM_THREADS = 10;

    static class RecursiveSumOfN {
        long from, to;

        public RecursiveSumOfN(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public Long compute() {

            long localSum = 0;
            for (long i = from; i <= to; i++) {
                localSum += i;
            }
            System.out.printf("\tSum of value range %d to %d is %d %n", from, to, localSum);
            return localSum;

        }
    }

    public static void main(String[] args) {
        Long computedSum = new RecursiveSumOfN(0, N).compute();

        long formulaSum = (N * (N + 1)) / 2;
        System.out.printf("Sum for range 1..%d; computed sum = %d, " +
                "formula sum = %d %n", N, computedSum, formulaSum);
    }
}
