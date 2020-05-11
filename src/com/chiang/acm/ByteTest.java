package com.chiang.acm;

public class ByteTest {
    public static void main(String[] args) {
        byte[] blist = new byte[]{1, 10, 120, 127, -1, -2, -10, -127, -128};
        for (int i = 0; i < blist.length; i++) {
            int a = blist[i];
            int b = blist[i] & 0xff;
            int c = blist[i] & 0xFF;

            System.out.println(a + " - " + b + " - " + c);
        }
    }
}
