package com.chiang.thread;

public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Yes");
                }
            }
        };

        ThreadDaemon threadTest = new ThreadDaemon();
        threadTest.wait();
        threadTest.notify();

        thread.setDaemon(true);
        thread.start();
    }
}
