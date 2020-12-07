package com.chiang.java.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PF14EBBQ
 * 打印ABC
 */
public class LockLearn {
    public static void main(String[] args) {
        final ReentrantLockThread ad = new ReentrantLockThread();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopA(i);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopB(i);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                ad.loopC(i);
            }
        }, "C").start();
    }
}

class ReentrantLockThread {

    /**
     * 当前执行线程标记
     */
    private volatile int num = 1;
    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int loop) {
        lock.lock();
        try {
            if (num != 1) {
                condition1.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + "第" + loop + "轮" + "-第" + i + "次");
            }
            num = 2;
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void loopB(int loop) {
        lock.lock();
        try {
            if (num != 2) {
                condition2.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + "第" + loop + "轮" + "-第" + i + "次");
            }
            num = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int loop) {
        lock.lock();
        try {
            if (num != 3) {
                condition3.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + "第" + loop + "轮" + "-第" + i + "次");
            }
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * @Description ReentrantLock 非condition 实现
 * print ABC
 */
class Main {
    public static void main(String[] args) {
        PrintBean print = new PrintBean();
        new Thread(new PrintA(print)).start();
        new Thread(new PrintB(print)).start();
        new Thread(new PrintC(print)).start();
    }


    static class PrintA implements Runnable {
        private final PrintBean print;

        PrintA(PrintBean print) {
            this.print = print;
        }

        @Override
        public void run() {
            print.printA();
        }
    }

    static class PrintB implements Runnable {
        private final PrintBean print;

        PrintB(PrintBean print) {
            this.print = print;
        }

        @Override
        public void run() {
            print.printB();
        }
    }

    static class PrintC implements Runnable {
        private final PrintBean print;

        PrintC(PrintBean print) {
            this.print = print;
        }

        @Override
        public void run() {
            print.printC();
        }
    }

    static class PrintBean {
        private final Lock lock = new ReentrantLock();
        private int num = 1;

        public void printA() {
            while (true) {
                lock.lock();
                try {

                    if (num == 1) {
                        System.out.println("A");
                    }
                    num = 2;

                } finally {
                    lock.unlock();
                }

            }
        }

        public void printB() {
            while (true) {

                lock.lock();
                try {
                    if (num == 2) {
                        System.out.println("B");
                    }
                    num = 3;
                } finally {
                    lock.unlock();
                }
            }
        }

        public void printC() {
            while (true) {

                lock.lock();
                try {
                    if (num == 3) {
                        System.out.println("C");
                    }
                    num = 1;
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}

/**
 *
 */
class SynchronizedTest {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println('a');
        }).start();
        new Thread(() -> {
            System.out.println('b');
            System.out.println(Thread.currentThread().getName());
        }, "abc").start();
        new Thread(() -> {
            System.out.println('c');
        }).start();
    }
}
