package com.chiang.acm;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TreeConstruct {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        List<Integer> preList = Arrays.stream(pre).boxed().collect(Collectors.toList());
        List<Integer> postList = Arrays.stream(post).boxed().collect(Collectors.toList());
        if (preList.size() == 1) {
            return root;
        }
        //Collections.reverse(postList);
        int location = postList.indexOf(preList.get(1));
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, location + 2), Arrays.copyOfRange(post, 0, location + 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, location + 2, pre.length), Arrays.copyOfRange(post, location + 1, pre.length - 1));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = constructFromPrePost(new int[]{1,2,4,5,3,6,7},new int[]{4,5,2,6,7,3,1});
        TreeNode root = new TreeNode(0);
        List<Integer> proList = Arrays.asList(new Integer[]{0, 1, 2, 3});

        Integer[] integers = (Integer[]) proList.toArray();
        int[] ints = proList.stream().mapToInt(Integer::valueOf).toArray();

        System.out.println(integers);
        System.out.println(proList.indexOf(8));
        System.out.println(proList.indexOf(1));
        System.out.println(proList.subList(0, 1));
        System.out.println(proList.subList(1, 3));
        System.out.println(Arrays.copyOfRange(proList.toArray(), 0, 1).length);
    }

}
