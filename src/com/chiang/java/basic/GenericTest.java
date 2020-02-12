package com.chiang.java.basic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	// 用问号"?"代替具体的类型参数，如List<?>
	public static void getData(List<?> data) {
		System.out.printf("data: %s \n", data.get(0));
	}

	public static void getUperNumber(List<? extends Number> data) {
		//List<? extends Number>定义上限位Number类型
		System.out.printf("data: %s \n",data.get(0));
	}

	public static void main(String[] args) {
		/*
		 * 用同一个方法实例化了三种不同类型的对象。 因为getData()方法的参数是List类型,而name,age,number
		 * 都是List的一种，所以name,age,number都可以作为这个 方法的实参，这就是类型通配符的好处。
		 */
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number> number = new ArrayList<Number>();

		name.add("icon");
		age.add(18);
		number.add(314);

		getData(name);
		getData(age);
		getData(number);
		
		//The method getUperNumber(List<? extends Number>) in the type GenericTest is not applicable for the arguments (List<String>)
		//getUperNumber(name);
		getUperNumber(age);
		getUperNumber(number);
	}

}
