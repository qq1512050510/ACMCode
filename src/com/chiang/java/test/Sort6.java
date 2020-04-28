package com.chiang.java.test;

import java.util.*;

import static java.util.Comparator.*;

public class Sort6 {
    public static void main(String[] args) {
        List words = Arrays.asList("A","c","E",null,"r","p",null);
        //words.sort(Comparator.nullsLast(Comparator.reverseOrder()));
        words.sort(nullsFirst(reverseOrder()));
        System.out.print(words);
        Map test = new LinkedHashMap();
    }
}
