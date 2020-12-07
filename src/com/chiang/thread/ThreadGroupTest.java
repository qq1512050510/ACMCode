package com.chiang.thread;

public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup group2 = new ThreadGroup("group2");
        ThreadGroup group = new ThreadGroup("group") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.printf("%s:%s%n", t.getName(), e.getMessage());
            }
        };
        Thread thread = new Thread(group, () -> {
            throw new RuntimeException("测试异常");
        });
        thread.setDaemon(true);
        thread.start();
        //thread.join();

        System.out.println(group.activeCount());
        Thread[] threads = new Thread[group1.activeCount()];
    }
}
