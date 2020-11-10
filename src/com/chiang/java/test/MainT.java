package com.chiang.java.test;

import lombok.SneakyThrows;

public class MainT {
    public static void main(String[] args) {

    }

}

class TwoLockPrinter implements Runnable {

    private static final int PRINT_COUNT = 100;

    private final Object frontLock;

    private final Object thisLock;

    private final char printChar;

    TwoLockPrinter(Object frontLock, Object thisLock, char printChar) {
        this.frontLock = frontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }


    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.println(printChar);
        }

    }

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lock = new Object();
        TwoLockPrinter a = new TwoLockPrinter(lockA, lock, 'a');
        TwoLockPrinter b = new TwoLockPrinter(lockA, lock, 'b');
        new Thread(a).start();
        new Thread(b).start();
    }
}
