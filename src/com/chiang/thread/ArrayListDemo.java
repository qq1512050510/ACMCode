package com.chiang.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    list.add(1);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                list.add(2);
            }
        };
        //t1.start();
        //t2.start();
        // 偶尔会抛出异常 ArrayIndexOutOfBoundsException; //new ArrayIndexOutOfBoundsException();
        String[] sList = new String[]{"1", "2"};
        Integer[] intList = new Integer[]{1, 2};
        int[] iList = new int[]{1, 2};
        System.out.println(Arrays.asList(sList));
        System.out.println(Arrays.asList(Arrays.copyOf(sList, sList.length * 2)));

        System.out.println(Arrays.asList(intList));
        System.out.println(Arrays.asList(Arrays.copyOf(intList, intList.length * 2)));


        System.out.println("----------------");
        System.out.println(iList.length);
        System.out.println("----------------");

        System.out.println(iList);
        System.out.println();
        int[] ints = Arrays.copyOf(iList, iList.length * 2);
        List intListTest = Collections.singletonList(Arrays.copyOf(iList, iList.length * 2));
        System.out.println(ints[3]);

    }
}
