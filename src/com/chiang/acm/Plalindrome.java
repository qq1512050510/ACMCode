package com.chiang.acm;

import org.mortbay.io.nio.SelectorManager;

import java.util.ArrayList;
import java.util.List;

public class Plalindrome {
    public String longestPalindrome(String s) {
        List<String> sChar = new ArrayList<String>();
        int max = 0;
        int len = 0;
        int loc = 0;
        int locMax = 0;
        for (int i = 0; i < s.length(); i++) {
            len=0;
            for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    len+=2;
                    loc = i;
                } else {
                    break;
                }
            }
            if (len > max) {
                locMax = loc;
            }

            max = len > max ? len : max;
            len = 1;
            for (int j = 0; i - 1 - j >= 0 && i + 1 + j < s.length(); j++) {
                if (s.charAt(i - 1 - j) == s.charAt(i + 1 + j)) {
                    len+=2;
                    loc = i;
                } else {
                    break;
                }
            }
            if (len > max) {
                locMax = loc;
            }
            max = len > max ? len : max;
        }
        System.out.println(max);
        System.out.println(locMax);
        if(max<=1){
            if(s.length()==0)
                return "";
            return String.valueOf(s.charAt(0));
        }
        if(max%2==0){
            return s.substring(locMax-max/2+1,locMax+max/2+1);
        }else{
            return s.substring(locMax-(max-1)/2,locMax+(max-1)/2+1);
        }

    }

    public static void main(String[] args) {
        Plalindrome plalindrome = new Plalindrome();
        System.out.println(plalindrome.longestPalindrome("bb"));
    }
}
