package com.chiang.java8.test;


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class MaxFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String numCount = in.next();
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < Integer.parseInt(numCount); i++) {
            numList.add(in.nextInt());
        }
        String numListString = in.nextLine();

      /*  numList.forEach((p) -> {
            System.out.println(p);
        });*/

        System.out.println(calSum(numList));
    }

    public static Integer calSum(List<Integer> numList) {
        List<Integer> numCalList = new ArrayList<Integer>();
        Integer sum = 0;
        while (numList.size() > 1) {
            int key = 0;
            Integer sumMin = numList.get(0) + numList.get(1);
            for (int i = 1; i < numList.size() - 1; i++) {
                Integer sumFor = numList.get(i) + numList.get(i + 1);
                if (sumMin > sumFor) {
                    key = i;
                    sumMin = sumFor;
                }
            }

            sum += sumMin;
            numList.set(key, sumMin);
            numList.remove(key + 1);
            System.out.println(sumMin);
            System.out.println(sum);
            System.out.println(numList);
        }
        return sum;
    }
}
/**手动模拟最小情况，发现关键就是在确定区间，确定分割点*/


class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n+1];
        int[] preSum = new int[n+1];
        for(int i = 1; i <= n; i++){
            money[i] = sc.nextInt();
            if(i == 1) preSum[i] = money[i];
            else preSum[i] = preSum[i-1] + money[i];
        }
        sc.close();

        int[][] dp = new int[n + 1][n + 1];
        for(int len = 2; len <= n; len++){
            for(int i = 1; i <= n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = preSum[j] - preSum[i - 1];
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k + 1][j] + sum);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}


