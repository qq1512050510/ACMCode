package com.chiang.acm;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FindRepeatNum {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Vector vector;
        Stack stack;
        /*AtomicInteger returnInt = new AtomicInteger(0);
        Arrays.stream(nums).forEach(num -> {
            if (set.contains(num)) {
                returnInt.set(num);
                return;
            }
            set.add(num);
        });
        return returnInt.get();
        */
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNum findRepeatNum = new FindRepeatNum();
        System.out.println(findRepeatNum.findRepeatNumber(new int[]{1, 2, 3, 4, 1}));
    }
}
