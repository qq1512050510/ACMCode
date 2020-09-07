package com.chiang.java8.test;

import org.apache.log.output.jms.MessageBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareTest {
    public static List<A> inventory = new ArrayList<A>();

 /*   private static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());// 实际上利用内部类 延迟的原理,代码不相关 无需进入到启动代理执行
        }
    }*/

    private static void startThread(Runnable task) {
        new Thread(task).run();
    }

    private static Comparator<String> newComparator1(){
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };
    }

    public static void main(String[] args) {
        inventory.add(new A(1));
        inventory.add(new A(2));
        inventory.add(new A(5));
        inventory.add(new A(3));
        inventory.sort(Comparator.comparing(A::getWeight));
        System.out.println(inventory);
        String msgA = "123", msgB = "123", msgC = "123";
        /*log(2, () -> {
            System.out.println("lambda 是否执行了");
            return msgA + msgB + msgC;
        });*/
        startThread(() -> System.out.println("执行线程！！！"));

    }

}

class A {
    String name;
    int weight;

    public A(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
