package com.chiang.java8.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        String p1 = in.next();
        String p2 = in.next();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Hello World!");
        boolean addOneState = false;

        for(int i=0;i<p1.length()&&i<p2.length();i++){
            int addOne = 0;
            if(addOneState){
                addOne = 1;
            }
            Integer m = new Integer(123);
            int aInt = m.intValue();
            System.out.print(Integer.parseInt(String.valueOf(p1.charAt(i))));
            System.out.println(Integer.parseInt(String.valueOf(p2.charAt(i))));


        }
        System.out.println(getMaxSub(new int[]{1, 2}));

    }

    public static Integer[] getMaxSub(int[] iList) {
        return null;
    }
}