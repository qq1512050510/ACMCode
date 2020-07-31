package com.chiang.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCount {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入：");
		Set words = tokenSet(console.nextLine());
		words.add("testa");
		System.out.println(words);
		Map map = new HashMap();
		
	}
	static Set tokenSet(String line){
		String [] tokens = line.split(" ");
		return new HashSet(Arrays.asList(tokens));
	}
}
