package org.itstep;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelCopyDemo {

    static AtomicBoolean closed = new AtomicBoolean(false);

    static class ReadWriteThread extends Thread {
        public static final int SIZE = 100;
        private final InputStream in;
        private final OutputStream out;

        public ReadWriteThread(String name, InputStream in, OutputStream out) {
            super(name);
            this.in = in;
            this.out = out;
        }

        @Override
        public void run() {
            while (!readWrite()) {
                System.err.println("Worked out: " + getName());
                await();
            }
            if(!closed.get()) {
                try {
                    out.close();
                    closed.set(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void await() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean readWrite() {
            byte[] buff = new byte[SIZE];
            int count;
            synchronized (in) {
                try {
                    count = in.read(buff);
                    if(count > 0) {
                        out.write(buff, 0, count);
                    } else {
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Start copy");
        InputStream in = Files.newInputStream(Paths.get("alice.txt"));
        OutputStream out = Files.newOutputStream(Paths.get("alice.copy"));

        for (int i = 0; i < 10; i++) {
            new ReadWriteThread("Thread #" + (i + 1), in, out).start();
        }
    }
}
