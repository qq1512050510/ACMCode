package com.chiang.java.structure;

import java.util.*;

public class Fibonacci {
    public int f(int n) {
        Integer[] aa = new Integer[]{1, 1};
        List<Integer> aList = new LinkedList<>();
        aList.add(1);
        aList.add(1);
        if (n <= 1) {
            return aa[n];
        }
        for (int i = 2; i <= n; i++) {
            aList.add(aList.get(i - 1) + aList.get(i - 2));
        }
        return aList.get(n);
    }

    public int fdigui(int n) {
        Integer[] aa = new Integer[]{1, 1};
        if (n <= 1) {
            return aa[n];
        } else {
            return fdigui(n - 1) + fdigui(n - 2);
        }
    }

    //寻找最大verison
    public String[] getMaxVersion(String[] versionList) {
        List<String> m = new ArrayList<>();
        String maxS = "";
        List<String> returnL = new ArrayList<String>();
        //拆分重组
        for (int i = 0; i < versionList.length; i++) {
            String[] aList = versionList[i].split("\\.");
            String aString = "";
            for (int j = 0; j < aList.length; j++) {
                aString += Integer.parseInt(aList[j]) + ".";
            }
            System.out.println(aString);
            m.add(aString);
        }

        maxS = m.get(0);
        //寻找最大version
        for (int i = 0; i < m.size() - 1; i++) {
            if (maxS.compareTo(m.get(i + 1)) <= 0) {
                maxS = m.get(i + 1);
            }
        }
        //匹配最大version
        for (int i = 0; i < m.size(); i++) {
            if (maxS.compareTo(m.get(i)) == 0) {
                returnL.add(versionList[i]);
            }
        }
        //结果升序返回
       /* Collections.sort(returnL, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        //Arrays.sort(returnL.toArray(new String[returnL.size()]));
        return returnL.toArray(new String[returnL.size()]);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        long a1 = System.currentTimeMillis();
        System.out.println(f.f(10));
        long a2 = System.currentTimeMillis();
        System.out.println(a2 - a1);
        System.out.println(f.fdigui(10));
        long a3 = System.currentTimeMillis();
        System.out.println(a3 - a2);
        String m = "8";
        String n = "70";
        System.out.println(Integer.parseInt(m));
        System.out.println(Integer.parseInt(n));
        //System.out.println(f.getMaxVersion(new String[]{"0.1", "0.4.5", "1.1"}));
        System.out.println(f.getMaxVersion(new String[]{"1.01", "1.001", "1.0", "0.1.0"}));
        String v1 = "1.01";
        String v2 = "1.001";
        String v3 = "1.0";
        String v4 = "0.1.0";
        System.out.println(v1.compareTo(v2));
        System.out.println(v2.compareTo(v3));
        System.out.println(v3.compareTo(v4));
        System.out.println(v4.compareTo(v1));
        String[] versionS = f.getMaxVersion(new String[]{"1.01", "1.001", "1.0", "0.1.0"});
        for (int i = 0; i < versionS.length; i++) {
            System.out.println(versionS[i]);
        }

    }
}
