package com.chiang.java8.test;

import java.util.Scanner;

public class DiGui {
    //计数(不包括一个字符的情况)
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                //找首尾相同的字符串
                if (a[i] == a[j]) {
                    diGui(i, j, a);
                }
            }
        }
        System.out.println(count + s.length());
    }

    public static void diGui(int m, int n, int[] a) {
        //一个字符和两个字符的情况，注意m-n
        if (m - n == 1 || m == n) {
            count += 1;
        } else {
            //比较前后字符是否一一对应
            if (a[m] == a[n]) {
                diGui(m + 1, n - 1, a);
            } else {//不对应结束该方法
                return;
            }
        }
    }
}
