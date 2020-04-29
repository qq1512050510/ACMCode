package com.chiang.thread;

public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true){
                    System.out.println("Yes");
                }
            }
        };

        thread.setDaemon(true);
        thread.start();
    }
}
