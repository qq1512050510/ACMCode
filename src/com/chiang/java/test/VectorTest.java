package com.chiang.java.test;

import com.google.inject.internal.cglib.proxy.$FixedValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(1);
        vector.add("123");
        vector.forEach((t) -> System.out.println(t));
        Map map = new HashMap();
        map.put(1, 1);
        Map mapSafe = Collections.synchronizedMap(map);
        mapSafe.forEach((key, value) -> System.out.printf("key:%s,value:%s", key, value));
    }
}
