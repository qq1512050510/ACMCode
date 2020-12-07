package com.chiang.thread;

import lombok.SneakyThrows;

import javax.management.relation.RoleUnresolved;

public class ThreadPrint {
    static class PrintA implements Runnable {
        private Object frontLock;
        private Object thisLock;

        public PrintA(Object frontLock, Object thisLock) {
            this.frontLock = frontLock;
            this.thisLock = thisLock;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (frontLock) {
                    synchronized (thisLock) {
                        System.out.println("A");
                        thisLock.notify();
                    }
                    frontLock.wait();
                }
            }
        }
    }

    static class PrintB implements Runnable {
        private Object frontLock;
        private Object thisLock;

        public PrintB(Object frontLock, Object thisLock) {
            this.frontLock = frontLock;
            this.thisLock = thisLock;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (frontLock) {
                    synchronized (thisLock) {
                        System.out.println("B");
                        thisLock.notify();
                    }
                    frontLock.wait();
                }

            }
        }
    }

    static class PrintC implements Runnable {
        private Object frontLock;
        private Object thisLock;

        public PrintC(Object frontLock, Object thisLock) {
            this.frontLock = frontLock;
            this.thisLock = thisLock;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (frontLock) {
                    synchronized (thisLock) {
                        System.out.println("C");
                        thisLock.notify();
                    }
                    frontLock.wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();
        new Thread(new PrintA(lockC,lockA)).start();
        new Thread(new PrintB(lockA,lockB)).start();
        new Thread(new PrintC(lockB,lockC)).start();
    }
}
