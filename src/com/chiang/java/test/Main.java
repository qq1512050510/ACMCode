package com.chiang.java.test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @description 求数组的子集
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> iList = Arrays.asList(new Integer[]{1, 2, 3, 4});
        getSubList(iList);
    }

    public static void getSubList(List<Integer> iList) {
        // 1,2,3,4
        int a = (int) Math.pow(2, iList.size()) - 1;
        System.out.println(Integer.toBinaryString(a).charAt(0) == '1');

        out.println(fixLengthBins(Integer.toBinaryString(10), 10));
        for (int i = a; i >= 1; i--) {
            out.print(fixLengthBins(Integer.toBinaryString(i), iList.size()) + " ");
            for (int j = 0; j < iList.size(); j++) {
                if (fixLengthBins(Integer.toBinaryString(i), iList.size()).charAt(j) == '1') {
                    out.print(iList.get(j) + " ");
                }
            }
            out.print(",");
        }
    }

    public static String fixLengthBins(String bins, int length) {

        StringBuilder stringBuilder = new StringBuilder(bins);
        for (int i = bins.length(); i < length; i++) {
            stringBuilder.insert(0, "0");
        }
        return stringBuilder.toString();
    }

}
