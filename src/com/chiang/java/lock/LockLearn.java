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
