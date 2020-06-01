package com.chiang.acm;

import java.util.*;

public class TreeNodePro {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder[0] = 123;
        TreeNode root = new TreeNode(0);

        return root;
    }

    public TreeNode buildTree(List preorder, List inorder) {
        //preorder;
        System.out.println(preorder.get(0).getClass().toString());
        System.out.println(preorder.get(0));
        Integer m = (Integer) preorder.get(0);
        m = 123;
        preorder.set(0,new Integer(123));
        Queue mq = new LinkedList(preorder);
        Deque md = new LinkedList(preorder);
        //md.off
        for(;mq.peek()!=null;){
            System.out.println(mq.poll());
            
        }
        TreeNode root = new TreeNode(0);

        return root;
    }

    public static void main(String[] args) {
        Integer[] preorder = {1, 2, 3, 4};
        TreeNodePro pro = new TreeNodePro();
        List<Integer> integers = (List<Integer>) Arrays.asList(preorder);
        pro.buildTree(integers, integers);

        //pro.buildTree(preorder, preorder);
        System.out.println(preorder[0]);
        System.out.println(integers.get(0));
    }

}
