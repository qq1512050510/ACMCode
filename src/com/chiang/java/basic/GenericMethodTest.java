package com.chiang.java.basic;

public class GenericMethodTest {

	public static <E> void printElement(E[] YourArray) {
		// 这里<E>表示 你可以 输入任何类型的数组
		// 输出数组元素
		for (E element : YourArray) {
			System.out.printf("%s", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 创建不同类型数组 ： Integer, Double 和 Character
		Integer[] intArray = { 3, 6, 2, 4, 8 };
		Double[] doubleArray = { 3.3, 6.6, 9.9 };
		Character[] charArray = {'H','E','L','L','O'};
		printElement(intArray);
		printElement(doubleArray);
		printElement(charArray);
	}

}
