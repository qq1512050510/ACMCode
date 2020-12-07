package com.chiang.acm;

import java.util.*;
import java.util.stream.Collectors;

public class FindFutureMax {
    public int[] findMax(int[] l) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            while (!stack.empty() && l[i] > l[stack.peek()]) {
                int loc = stack.pop();
                result[loc] = i - loc;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] findL = new int[]{74, 46, 25, 79, 345, 45, 67, 89, 90,};
        System.out.println(Arrays.stream(new FindFutureMax().findMax(findL)).boxed().collect(Collectors.toList()));
    }
}
