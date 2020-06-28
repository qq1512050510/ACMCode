package com.chiang.thread;


class NoVisibility {
    private static boolean ready;
    public static int number = 35;
    private int numberTest = 21;
    public int numberA = 25;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NoVisibility().numberTest);
        NoVisibility.number = 23;
        new ReaderThread().start();
        //number = 42;
        ready = true;
    }
}