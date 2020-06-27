package com.chiang.thread;

import org.codehaus.jackson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class TaskCallable implements Callable<String> {
    private static final Logger log = LoggerFactory.getLogger(TaskCallable.class);
    String name;
    int sleep;

    public TaskCallable(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        log.info("[{}]开始执行任务", name);
        int random = new Random().nextInt(100);
        random = random + 1;
        log.info("[{}]任务开始睡眠[{}]秒", name, random);
        Thread.sleep(random * 1000);
        log.info("[{}]任务执行结束", name);
        return name;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<String>> results = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            results.add(pool.submit(new TaskCallable("The " + i, i)));
        }
        Future<String> done = null;
        int i = 0;
        while (null == done && i < 100) {
            Thread.sleep(1000);
            log.info("开始等待处理结果");
            for (Future f : results) {
                if (f.isDone()) {
                    done = f;
                    log.info("处理有了结果");
                    break;
                }
            }
            i++;
        }
        /**
         * shutDownNow，遍历线程池中的工作线程，逐个调用线程的interrupt方法来中断线程。
         * 注意：如果存在无法中断的任务，可能永远无法终止。
         */
        pool.shutdown();
        pool.shutdownNow();
        System.out.println(done.get());
    }
}
