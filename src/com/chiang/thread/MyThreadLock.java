package com.chiang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadLock implements Runnable {

    @Override
    public void run() {
        ReentrantLock lock = new ReentrantLock();

        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable t1 = new MyThreadLock();
        //new Thread(t1, "t1").start();
        //new Thread(t1, "t2").start();
        Runnable rt1 = new ThreadReentrantLock();
        Thread test1 = new Thread(rt1,"rt1");
        Thread test2 = new Thread(rt1,"rt2");
        test1.start();
        test2.start();
        test1.join();
        System.out.println("主线程执行完成");
    }
}

class ThreadReentrantLock implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock();
        }
    }
}
