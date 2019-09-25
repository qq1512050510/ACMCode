package test;

/***
 * @description 反序相等
 * url:https://www.nowcoder.com/practice/092e7068881549bd8985c379208ef3c2?tpId=94&&tqId=31067&rp=1&ru=/activity/oj&qru=/ta/bit-kaoyan/question-ranking
 * @author adp
 *
 */
public class Main3 {

	public static void main(String[] args) {
		for(int i=1000;i<10000;i++) {
			if(multiNineReverse(i))
				System.out.println(i);
		}
	}

	private static boolean multiNineReverse(int i) {
		int iNine = i*9;
		String nineString = String.valueOf(iNine);
		String iString = String.valueOf(i);
		int iLength = nineString.length();
		if(iLength!=iString.length()) {
			return false;
		}
		for(int l=0;l<iLength;l++) {
			if(iString.charAt(l)!=nineString.charAt(iLength-l-1)) {
				return false;
			}
		}
		return true;
	}

}
