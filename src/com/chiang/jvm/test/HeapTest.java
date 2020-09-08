package com.chiang.jvm.test;

import java.util.ArrayList;

public class HeapTest {
    byte[] a = new byte[1024 * 100];//100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<HeapTest>();
        while (true) {
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
