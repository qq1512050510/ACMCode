package com.chiang.acm;

import java.util.*;
public class TreeLayer {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public List<List<Integer>> layListFormat(TreeNode root){
        Deque<List> deque = new ArrayDeque<List>();
        List<TreeNode> tempList = new ArrayList<TreeNode>();
        tempList.add(root);
        for(;tempList.size()==0;){
            List<Integer> layerList = new ArrayList<Integer>();
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            //tempList = Arrays.copyOf()
        }
        return null;
    }
    public static void main(String[]args){
        int[]a = new int[args.length];
        String m = "1234567890";
        System.out.println(m.substring(3,6));
        System.out.println(m.substring(6));
        m.replace("-","");
        String n = "";
        m.replace(m,n);
    }
}
