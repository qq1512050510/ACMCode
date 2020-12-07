package com.chiang.java.lock;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * @author PF14EBBQ
 */
public class SemaphoreTest {

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    static class ThreadA extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                semaphoreA.acquire();
                System.out.print(Thread.currentThread().getName());
                System.out.println(" A");
                semaphoreB.release();
            }
        }
    }

    static class ThreadB extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                semaphoreB.acquire();
                System.out.println("B");
                semaphoreC.release();
            }
        }
    }

    static class ThreadC extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                semaphoreC.acquire();
                System.out.println("C");
                semaphoreA.release();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

}

