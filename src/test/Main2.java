package test;

import java.util.HashSet;
import java.util.Set;

/***
 * url:https://www.nowcoder.com/practice/b6735b1bd4ff488fb9a9032457410f66?tpId=94&&tqId=31068&rp=1&ru=/activity/oj&qru=/ta/bit-kaoyan/question-ranking
 * @author adp
 *
 */
public class Main2 {
 
	public static void main(String[] args) {
		Set<Integer> sumSet = new HashSet<Integer>();
		for(int i =0;i<=5;i++) {
			for(int j=0;j<=4;j++) {
				for(int k =0;k<=6;k++) {
					int sum = 8*i+10*j+18*k;
					sumSet.add(sum);
				}
			}
		}
		System.out.println(sumSet.size()-1);
		
	}

}
