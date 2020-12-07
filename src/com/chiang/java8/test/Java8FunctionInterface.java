package com.chiang.java8.test;

import io.netty.handler.codec.http2.Http2Settings;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class Java8FunctionInterface {

    public static Java8FunctionInterface create(final Supplier<Java8FunctionInterface> supplier) {
        return supplier.get();
    }

    public static void collide(final Java8FunctionInterface car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Java8FunctionInterface another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        final Java8FunctionInterface car = Java8FunctionInterface.create(Java8FunctionInterface::new);
        final List<Java8FunctionInterface> cars = Arrays.asList(car);
        List names = new ArrayList();
        names.add("Google");
        names.add("Runnoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
        HashMap a = new HashMap<String, Object>();
        a.put("1", "1");
        ConcurrentHashMap b = new ConcurrentHashMap<>();
        b.put("1", "1");
        Vector v = new Vector();
        v.add(123);
        v.get(0);
        List la = new ArrayList();
        List ll = new LinkedList();
        ReentrantLock lock = new ReentrantLock();
        Set s1 = new HashSet();
        Set s2 = new TreeSet();

        Map m1 = new HashMap();//无序
        Map m2 = new TreeMap();//自然序
        Map m3 = new LinkedHashMap();

        m1.put("HA", 1);
        m1.put("TT", 1);
        m1.put("SE", 1);
        m1.put("AB", 1);

        m2.put("AM", 1);
        m2.put("PQ", 1);
        m2.put("LS", 1);
        m2.put("RA", 1);

        m3.put("AM", 1);
        m3.put("PQ", 1);
        m3.put("LS", 1);
        m3.put("RA", 1);

        out.println(m1.keySet());
        out.println(m2.keySet());
        out.println(m3.keySet());
        out.println(3 | 9);

        String sByte = "0100";
        Integer aInteger = 1;
        out.println(sByte.getBytes());
        out.println(aInteger.byteValue());
    }
}
