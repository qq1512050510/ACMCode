package test;

import java.util.Scanner;
   
public class Main4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] s1 = sc.next().toCharArray();
            char[] s2 = sc.next().toCharArray();
            int len = s1.length;
            int[][] find = new int[26][len+1];
            for (int j = 0; j < 26; j ++) find[j][len] = -1;
            for (int i = len - 1; i >= 0; i --) {
                for (int j = 0; j < 26; j ++) find[j][i] = find[j][i+1];
                find[s1[i]-'a'][i] = i;
            }
            for(int[]row:find) {
            	for(int rowi:row) {
            		 System.out.print(rowi+" ");
            	}
            	System.out.println("-");
            }
            int res = 1;
            int index = 0;
            for (char cur: s2) {
                int first = find[cur-'a'][0];
                if (first == -1) { res = -1; break; }
                int seek = find[cur-'a'][index];
                if (seek != -1) {
                    index = seek + 1;
                } else {
                    res ++;
                    index = first + 1;
                }
            }
            System.out.println(res);
        }
    }
}