package com.chiang.acm;

import java.util.*;

public class FindRepeatNum {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Vector vector;
        Stack stack;
        Arrays.stream(nums).forEach(num -> {
            set.add(num);
        });
        System.out.println(set);
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNum findRepeatNum = new FindRepeatNum();
        findRepeatNum.solution(new int[]{1, 2, 3, 4, 1});
    }
}
