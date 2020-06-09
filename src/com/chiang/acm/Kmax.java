package com.chiang.acm;


import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Kmax {
    public int findKLargest(int[] nums, int k) {
        List<Integer> deque = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.size() < k) {
                deque.add(new Integer(nums[i]));
                Collections.sort(deque);
            } else {
                if (deque.get(deque.size() - 1) <= nums[i]) {
                    deque.remove(0);
                    deque.add(new Integer(nums[i]));
                } else if (deque.get(0) < nums[i]) {
                    deque.add(0, new Integer(nums[i]));
                    Collections.sort(deque);
                    deque.remove(0);
                }
            }
        }

        return deque.get(0);
    }

    public int findKthLargest1(int[] nums, int k) {
        List<Integer> dList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(dList);
        return dList.get(dList.size() - k);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 57, 12, 234};
        Integer[] integers = new Integer[]{1,2,3,4,5};
        System.out.println(new Kmax().findKLargest(ints, 2));
        System.out.println(new Kmax().findKthLargest1(new int[]{1, 2, 3, 4, 57, 12, 234}, 2));
        List<Integer> t1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3, 4, 57, 12, 234}));
        List<Integer> integerList = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Arrays.stream(ints).boxed().collect(Collectors.toList());
        Arrays.stream(integers);
        integerList.toArray();
        integerList.stream().mapToInt(Integer::new).toArray();
        List<String> stringList = new ArrayList<String>();
        String[] strings = new String[]{"123","234","234"};
        strings =  stringList.toArray(new String[0]);
        strings =  (String[])stringList.toArray();

        System.out.println(integerList);
        integerList.toArray();
        List<Integer> t = new ArrayList<>();
        t.add(0, 1);
        t.add(0, 2);
        t.add(2, 3);
        t.add(2, 4);
        t1.add(0, 1);
        System.out.println(t);
        //t1.remove(t1.size() - 1);
        Collections.sort(t1);
        System.out.println(t1);
    }
}
