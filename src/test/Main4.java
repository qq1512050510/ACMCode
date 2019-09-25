package test;

import java.util.Scanner;

/***
 * @description CodeForces 91A Newspaper Headline
 *              url:https://www.nowcoder.com/practice/ecc7f03ce0e54694a2c9a2147293e04c?tpId=43&tqId=21616&tPage=1&rp=1&ru=/ta/acm-training&qru=/ta/acm-training/question-ranking
 * @author adp
 *
 */
public class Main4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String head = "";
		String format = "";
		while (sc.hasNext()) {
            char[] s1 = sc.next().toCharArray();
            char[] s2 = sc.next().toCharArray();
			long startTime = System.nanoTime();
			System.out.println(calculateCount(s1,s2));
			// ... the code being measured ...
			long estimatedTime = System.nanoTime() - startTime;
			//System.out.println(estimatedTime/1000/1000/1000+"ms");
		}
		

	}

	private static int calculateCount(char[] s1, char[] s2) {
		int countMatch = 0;
		int formatLength = s2.length;
		for(int i=0;i<formatLength;) {
			boolean matchOrNot = false;
			int headLength = s1.length;
			for(int j=0;j<headLength;j++) {
				if(i<formatLength&&j<headLength) {}
				else
					return countMatch;
				if(s2[i]==s1[j]) {
					i++;
					matchOrNot=true;
				}
				if(i==formatLength||j==headLength-1) {
					if(matchOrNot)
						countMatch++;
					else
						return -1;
					if(i==formatLength)
						return countMatch;
				}
			}
		}
		return countMatch;
	}

}

