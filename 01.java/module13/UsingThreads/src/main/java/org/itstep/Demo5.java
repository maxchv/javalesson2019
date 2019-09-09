package org.itstep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo5 {
	
    static class Friend {
        private final String name;
        Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }

        public void seyHi(Friend friend) {

            boolean myLock = lock.tryLock();
            boolean yourLock = friend.lock.tryLock();

            if(myLock && yourLock) {
                System.out.format("%s: %s said hi to me!%n",
                        name, friend.getName());
                friend.hiBack(this);
            } else {
                if(myLock) {
                    lock.unlock();
                }
                if(yourLock) {
                    friend.lock.unlock();
                }
            }
        }

        public void hiBack(Friend friend) {
            System.out.format("%s: %s"
                + " has said hi back to me!%n",
                name, friend.getName());
        }
    }

    // Deadlock demo
    public static void main(String[] args) {
        final Friend petro = new Friend("Petro");
        final Friend vano =  new Friend("Vano");

        System.out.println("Start");
        new Thread(() -> petro.seyHi(vano)).start();
        new Thread(() -> vano.seyHi(petro)).start();
        System.out.println("End");
    }
}