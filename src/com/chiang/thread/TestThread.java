package com.chiang.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//@Slf4j(topic = "c.Test")
public class TestThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //log.debug("running");
                System.out.println("running");
            }
        };
        Runnable r1 = ()->{
            System.out.println("lambda running");
        };
        Thread t = new Thread(r,"t1");
        t.start();
        Thread t1 = new Thread(r1,"t2");
        t1.start();
        StringBuffer sb = new StringBuffer();
        sb.append("abc");
        sb.append("cde");
        System.out.println(sb.toString());
        Stack stack = new Stack();
        //stack.peek();
        //FutureTask

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.printf("%s...","Running");
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread tf = new Thread(task,"tf1");

        tf.start();
        System.out.printf("返回结果：%d",task.get());
        Runnable joinTest = ()->{
            System.out.println("JoinTest");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinTest End");
        };
        Thread tr = new Thread(joinTest,"tr1");
        //joinTest.run();
        tr.start();
        tr.join();
        Thread.sleep(500);
        System.out.println("主线程结束");

    }
}
