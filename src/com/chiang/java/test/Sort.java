package com.chiang.java.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringCompator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        System.out.print(o1+":"+o2+":");
        System.out.println(o1.compareTo(o2));
        return o1.compareTo(o2);
    }
}

public class Sort {

    public static void main(String[] args) {
        String[] strings = {"n","n","c","v","d"};
        List stringList = Arrays.asList(strings);
        Collections.sort(stringList,new StringCompator());
        System.out.println(stringList);
    }
}
