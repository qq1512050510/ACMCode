package com.chiang.java.test;

import java.util.*;

import static java.util.Comparator.*;

public class Sort6 {
    public static void main(String[] args) {
        List words = Arrays.asList("A","c","E",null,"r","p",null);
        //words.sort(Comparator.nullsLast(Comparator.reverseOrder()));
        words.sort(nullsFirst(reverseOrder()));
        List wordNotNull = Arrays.asList("a","e","f","k","c");
        wordNotNull.sort(reverseOrder());
        System.out.println(words);
        System.out.println(wordNotNull);
        Map test = new LinkedHashMap();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("afbsfasdfsa");
        System.out.println(stringBuffer.reverse());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("afbsfasdfsa");
        System.out.println(stringBuilder.reverse());
    }
}
