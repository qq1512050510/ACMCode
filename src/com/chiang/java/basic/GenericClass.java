package com.chiang.java.basic;

public class GenericClass<T> {
	// 泛型类和非泛型类生命差不多，泛型类在非泛型类的声明基础之上添加了类型参数的声明。此类型参数的声明和泛型方法的参数声明方式一样。
	private T t;
	public void setValue(T t) {
		this.t = t;
	}
	public T getValue() {
		return this.t;
	}
	public static void main(String[] args) {
		GenericClass<Integer> intValue = new GenericClass<Integer>();
		GenericClass<String> strValue = new GenericClass<String>();
		
		intValue.setValue(new Integer(3));
		strValue.setValue(new String("yisun03's blog"));
		
		System.out.printf("整数类型实例化：%d\n", intValue.getValue());
		System.out.printf("字符串类型实例化：%d\n", strValue.getValue());
	}
}
