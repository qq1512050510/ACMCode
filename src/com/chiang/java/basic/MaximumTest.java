package com.chiang.java.basic;

public class MaximumTest {

	// 比较三个值并返回最大值
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {

		// 参数只接收那种可以用来比较大小的类型参数
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.printf("%d,%d和%d中的最大的树为%d\n\n", 3, 6, 9, maximum(3, 6, 9));
	}

}
