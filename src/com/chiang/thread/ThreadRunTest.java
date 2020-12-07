package com.chiang.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadRunTest {
    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                log.info("t1 running...");
            }
        },"t1").start();
        new Thread(()->{
            while(true){
                log.info("t2 running...");
            }

        },"t2").start();
    }
}
