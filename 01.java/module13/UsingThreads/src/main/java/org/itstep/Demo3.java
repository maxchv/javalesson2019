package org.itstep;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {

    public static void main(String[] args) throws Exception {
        concurrencyRace();
    }

    // Демонстрация проблемы борьбы за ресурсы
    private static void concurrencyRace() throws InterruptedException {
        Account account = new Account(100_000);
        System.out.println("Begin balance " + account.getBalance());

        // TODO: Создать поток для снятия денег со счета
        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) { // 100_000 - 100_000 * 1 = 0
                account.withdraw(1);
            }
        });

        // TODO: Создать поток для внесения денег на счет
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) { // 0 + 100_000 * 1 = 100_000
                account.deposit(1);
            }
        });

        if (withdrawThread != null) {
            withdrawThread.start();
        }

        if (depositThread != null) {
            depositThread.start();
        }

        if (withdrawThread != null) {
            withdrawThread.join();
        }
        if (depositThread != null) {
            depositThread.join();
        }

        System.out.println("End balance " + account.getBalance());
    }
}

/**
 * Банковский счет
 */
class Account {
    //private long balance;

    private AtomicLong balance = new AtomicLong(0);

    Lock lock = new ReentrantLock();

    //Object locker = new Object();

    public Account(long l) {
        this.setBalance(l);
    }

    public long getBalance() {
        return balance.get();
    }

    private void setBalance(long balance) {
//        this.balance = balance;
        this.balance.set(balance);
    }

    // пополнения счета
    public void deposit(long amount) throws IllegalArgumentException {
//        synchronized (this) {
        checkAmountNonNegative(amount);

        //balance += amount; // Concurrency Race Condition
        try {
            lock.lock();
            balance.addAndGet(amount);
        } finally {
            lock.unlock();
        }
//        }
    }

    private static void checkAmountNonNegative(long amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }

    // снятие денег
    public void withdraw(long amount) throws IllegalArgumentException {
//        synchronized (this) {
        checkAmountNonNegative(amount);

        if (balance.get() < amount) {
            throw new IllegalArgumentException("not enough money");
        }
        //balance -= amount; // Concurrency Race Condition
        try {
            lock.lock();
            balance.addAndGet(-amount);
        } finally {
            lock.unlock();
        }
//        }
    }
}
