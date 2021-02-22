package com.chiang.acm;

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
    private int num=0;

    public void count() {
        for (int i = 0; i <= 10; i++) {
            num += i;
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }
}
