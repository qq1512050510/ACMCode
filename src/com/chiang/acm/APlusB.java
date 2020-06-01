package com.chiang.acm;


import org.apache.hadoop.util.hash.Hash;

import java.util.*;
import java.util.stream.Collectors;

class MyComparator implements Comparator{


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
public class APlusB {
    public static int[] twoSum(int[] nums, int target) {
        int[] sumKey = new int[2];
        sumKey[0] = 1;
        int[] ints = new int[]{0, 1};
        List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());

        Map<Integer,Integer> hash = new HashMap<Integer, Integer>();
        List<Integer> l1 = new ArrayList<Integer>();
        Collections.reverse(l1);
        l1.size();
        Collections.sort(l1,new MyComparator());
        List<Integer> l2 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Map<String,String> map = new HashMap<>();
        String a = "";
        a.length();
        String[] aString = {"123","234"};
        String s = "";
        s.length();
        Integer.parseInt(s.charAt(0)+"");
        char[] list = {'a','b'};

        list[3] = aString[0].charAt(0);
        String m0 = String.valueOf(list[0]);
        Math.pow(1,2);
        int m = 123;
        String mString = String.valueOf(m);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, 5, 6};
        twoSum(ints, 9);
    }


}
