package com.chiang.acm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PF14EBBQ
 */
public class ThreadSafeAndUnsafe {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            Count count = new Count();

            @Override
            public void run() {
                count.count();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}

class Count {

    public void count() {

        AtomicInteger num = new AtomicInteger(0);
        for (int i = 0; i <= 10; i++) {
            num.addAndGet(i);
        }
        System.out.println(Thread.currentThread().getName() + "-" + num.get());
    }
}
