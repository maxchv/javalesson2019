package org.itstep;

public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        // Начальный счет
        Account2 account = new Account2(0);

        // Накопим немного денег
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50_000_000; i++) {
                    account.deposit(1);
                }
            }
        }).start();

        // Снять деньги со счета???
        account.withdraw(50_000_000);

        /* TODO: вызвать метод waitAndWithdraw()*/
        System.out.println("Calling waitAndWithdraw()...");

        System.out.println("waitAntWithdraw() finished " + account.getBalance());
    }
}

class Account2 {
    private long balance;

    Object locker = new Object();

    public Account2() {
        this(0L);
    }

    public Account2(long l) {
        this.setBalance(l);
    }

    public long getBalance() {
        return balance;
    }

    private void setBalance(long balance) {
        this.balance = balance;
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);

        synchronized (locker) {
            balance += amount;
            locker.notify();
        }
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }

    public void withdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);

        synchronized (locker) {
            while (balance < amount) {
                //throw new IllegalArgumentException("not enough money");
                locker.wait(1000);
            }
        }

        balance -= amount;
    }
}