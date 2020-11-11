package com.chiang.java.test;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainT {
    public static void main(String[] args) {

    }

}

/**
 * 多线程循环打印 ABC
 * synchronized实现
 */
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
            synchronized (frontLock) {
                synchronized (thisLock) {
                    System.out.println(printChar);
                    thisLock.notify();
                }
                frontLock.wait();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        TwoLockPrinter a = new TwoLockPrinter(lockC, lockA, 'a');
        TwoLockPrinter b = new TwoLockPrinter(lockA, lockB, 'b');
        TwoLockPrinter c = new TwoLockPrinter(lockB, lockC, 'c');

        new Thread(a).start();
        Thread.sleep(10);
        new Thread(b).start();
        new Thread(c).start();
    }
}


/**
 * 基于两个lock实现连续打印abcabc....
 *
 * @author lixiaoxi
 */
class TwoLockPrinter2 implements Runnable {

    // 打印次数
    private static final int PRINT_COUNT = 10;
    // 前一个线程的打印锁
    private final Object fontLock;
    // 本线程的打印锁
    private final Object thisLock;
    // 打印字符
    private final char printChar;

    public TwoLockPrinter2(Object fontLock, Object thisLock, char printChar) {
        this.fontLock = fontLock;
        this.thisLock = thisLock;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        // 连续打印PRINT_COUNT次
        for (int i = 0; i < PRINT_COUNT; i++) {
            // 获取前一个线程的打印锁
            synchronized (fontLock) {
                // 获取本线程的打印锁
                synchronized (thisLock) {
                    //打印字符
                    System.out.print(printChar);
                    // 通过本线程的打印锁唤醒后面的线程
                    // notify和notifyall均可,因为同一时刻只有一个线程在等待
                    thisLock.notify();
                }
                // 不是最后一次则通过fontLock等待被唤醒
                // 必须要加判断，不然虽然能够打印10次，但10次后就会直接死锁
                if (i < PRINT_COUNT - 1) {
                    try {
                        // 通过fontLock等待被唤醒
                        fontLock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 打印A线程的锁
        Object lockA = new Object();
        // 打印B线程的锁
        Object lockB = new Object();
        // 打印C线程的锁
        Object lockC = new Object();

        // 打印a的线程
        Thread threadA = new Thread(new TwoLockPrinter2(lockC, lockA, 'A'));
        // 打印b的线程
        Thread threadB = new Thread(new TwoLockPrinter2(lockA, lockB, 'B'));
        // 打印c的线程
        Thread threadC = new Thread(new TwoLockPrinter2(lockB, lockC, 'C'));

        // 依次开启a b c线程
        threadA.start();
        // 确保按顺序A、B、C执行
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);
        threadC.start();
        Thread.sleep(100);
    }

}

/**
 * @description ReentrantLock
 */
class TwoLockReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        // 打印a的线程
        Thread threadA = new Thread(new Print(lock, conditionC, conditionA, 'A'));
        // 打印b的线程
        Thread threadB = new Thread(new Print(lock, conditionA, conditionB, 'B'));
        // 打印c的线程
        Thread threadC = new Thread(new Print(lock, conditionB, conditionC, 'C'));

        // 依次开启a b c线程
        threadA.start();
        // 确保按顺序A、B、C执行
        Thread.sleep(100);
        threadB.start();
        threadC.start();
    }

    static class Print implements Runnable {
        private static final int PRINT_TIMES = 10;
        private final ReentrantLock rLock;
        private final Condition preCondition;
        private final Condition curCondition;
        private final char printChar;

        public Print(ReentrantLock rLock, Condition preCondition, Condition curCondition, char printChar) {
            this.rLock = rLock;
            this.preCondition = preCondition;
            this.curCondition = curCondition;
            this.printChar = printChar;
        }

        @Override
        public void run() {
            rLock.lock();
            try {
                for (int i = 0; i < PRINT_TIMES; i++) {
                    System.out.println(printChar);
                    preCondition.signal();
                    curCondition.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rLock.unlock();

            }


        }
    }
}

/**
 * print ABC
 */
class ThreadPrint implements Runnable {

    public static volatile int state = 0;
    private static final int PRINT_COUNT = 10;
    private final Object lockObject;

    private final int printFlag;

    private final int nextFlag;

    private final char printChar;

    ThreadPrint(Object lockObject, int printFlag, int nextFlag, char printChar) {
        this.lockObject = lockObject;
        this.printFlag = printFlag;
        this.nextFlag = nextFlag;
        this.printChar = printChar;
    }

    //@SneakyThrows
    @Override
    public void run() {
        synchronized (lockObject) {
            while (true) {
                //for (int i = 0; i < PRINT_COUNT; i++) {
                while (true) {
                    if (state == printFlag) {
                        break;
                    }
                    try {
                        lockObject.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(printChar);

                state = nextFlag;

                lockObject.notifyAll();

            }

        }
    }

    public static void main(String[] args) {

        Object lock = new Object();
        Thread a = new Thread(new ThreadPrint(lock, 0, 1, 'a'));
        Thread b = new Thread(new ThreadPrint(lock, 1, 2, 'b'));
        Thread c = new Thread(new ThreadPrint(lock, 2, 0, 'c'));

        a.start();
        b.start();
        c.start();

    }
}

