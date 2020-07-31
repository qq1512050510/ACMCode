package com.chiang.acm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChessLocation {
    public static void main(String[] args) {
        byte a = -1;
        Byte b = 1;
        System.out.println("byte==>min-max:" + Byte.MIN_VALUE + "~" + Byte.MAX_VALUE + ",位数：" + Byte.SIZE);
        System.out.println(a >> 1);
        ChessLocation.calculateLocation();
        System.out.println(String.valueOf(a));
        //System.out.println(new BigInteger(String.valueOf(1),a).toString(16));
        //int aint = a & 0xFF;
        int aint = a ;
        //String hv = Integer.toHexString(aint);
        String hv = Integer.toBinaryString(aint);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hv);
        System.out.println(aint);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 通过一个字节存储
     */
    public static void calculateLocationByOneByte(){

    }

    /**
     * 直接遍历
     */
    public static void calculateLocation() {
        //x坐标一致代表，同一列
        String[] locationAList = {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};
        String[] locationBList = {"a4", "a5", "a6", "b4", "b5", "b6", "c4", "c5", "c6"};
        String[] locationX = {"a", "b", "c"};

        for (int i = 0; i < locationX.length; i++) {
            for (int j = 1; j <= 3; j++) {
                List<String> locationXList = new ArrayList<>(Arrays.asList(locationX));
                System.out.println(locationXList.remove(locationX[i]));

                for (int k = 4; k <= 6; k++) {
                    System.out.print(locationX[i] + "" + j + " ");
                    System.out.println(locationXList.get(0) + "" + k + "");
                }
                for (int k = 4; k <= 6; k++) {
                    System.out.print(locationX[i] + "" + j + " ");
                    System.out.println(locationXList.get(1) + "" + k + "");
                }
            }

        }
    }
}
