package test;
/***
 * url:https://www.nowcoder.com/practice/1b79865e2f534db0adba84dca10d6bae?tpId=94&&tqId=31069&rp=1&ru=/activity/oj&qru=/ta/bit-kaoyan/question-ranking
 * @author adp
 *
 */
public class Main {
	private static boolean panduanhuiwen(String sumInt) {
		int sLength = sumInt.length();
		sLength--;
		for(int i=0;i<(int)Math.ceil((float)sumInt.length()/2);i++) {
			if(sumInt.charAt(i)!=sumInt.charAt(sLength-i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		for(int i=0;i<256;i++) {
			int sInt = i*i;
			if(panduanhuiwen(String.valueOf(sInt))) {
				System.out.println(i);
			}
		}

	}

}
