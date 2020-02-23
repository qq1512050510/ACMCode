package com.chiang.java.test;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String str = new String("This is a test String,I like it.");
		StringTokenizer st = new StringTokenizer(str, " :,|.");// 默认不打印分隔符,分隔符为 空格 冒号 逗号 竖线 句号
		// StringTokenizer st=new StringTokenizer(str,":,|",true);//打印分隔符
		// StringTokenizer st=new StringTokenizer(str,":,|",false);//不打印分隔符
		//StringTokenizer st = new StringTokenizer(s);
		System.out.printf("Token total :%s\n",st.countTokens() );
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
