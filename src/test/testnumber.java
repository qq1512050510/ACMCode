package test;
import java.util.*;


public class testnumber {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		String read = "";
		while(!read.equals("end")) {
		Scanner scanner = new Scanner(System.in);
		read = scanner.nextLine();
		
		String[] split = read.split(" ");
		Integer[] A=new Integer[split.length]; 
        for(int i=0;i<split.length;i++){
            Integer ss = new Integer(split[i]);
            A[i] = ss;
        }
        for(int i = 0; i < A.length; ++i){
            if(!list.contains(A[i]))
                list.add(A[i]);
        }
        //将不重复的元素返回给原始数组
        for(int i = 0; i < list.size(); ++i){
            A[i] = (int)list.get(i);
        }
        //输出查看结果
        for(int i = 0; i < list.size(); ++i){
            System.out.print(A[i] + " ");
        }
        System.out.println();
        
               
		}				
	}
}
