package com.chiang.java.test;

import java.util.*;

public class SortOrderNo {
    static class SortComparator implements Comparator<String> {

        public int compare(String o1, String o2) {
            return -o1.compareTo(o2);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList = Arrays.asList("123456", "667821", "234567", "112046");
        Collections.sort(stringList, new SortComparator());
        System.out.println(stringList);
        System.out.print(stringList.get(0).compareTo(stringList.get(1)));
    }
}
