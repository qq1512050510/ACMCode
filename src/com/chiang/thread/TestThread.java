package com.chiang.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Stack;

//@Slf4j(topic = "c.Test")
public class TestThread {
    public static void main(String[] args) {
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
        stack.peek();



    }
}
