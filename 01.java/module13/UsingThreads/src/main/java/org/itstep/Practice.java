package org.itstep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Practice {

    public static final String abcd = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int start;

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        System.out.println(cores);
        for(int i=0; i<4; i++) {
            Future<Integer> future = executorService.submit(() -> {
                while (start < abcd.length()) {
                    synchronized (abcd) {
                        System.out.print(abcd.substring(start, start + 4));
                        start += 4;
                    }
                }
                return 10;
            });
        }

        executorService.shutdown();
    }
}
