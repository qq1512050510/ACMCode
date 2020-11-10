package com.chiang.thread;

public class DaemonTest {
    // setDaemon 微信下载的例子 假如有一个线程,随着主程序存在而存在,停止而停止
    public static void main(String[] args) throws InterruptedException {
        Runnable threadDaemon = new ThreadTestR();
        Thread thread = new Thread(threadDaemon);
        //thread.setDaemon(true);
        thread.start();
        thread.join();
        for (int i = 0; i < Math.pow(2, 8); i++) {
            System.out.println(String.format("%s,%d", Thread.currentThread().getName(), i));
        }
    }
}

class ThreadTestR implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < Math.pow(2, 10); i++) {
            System.out.println(String.format("当前线程：%s，输出值：%d", Thread.currentThread().getName(), i));
        }
    }
}
