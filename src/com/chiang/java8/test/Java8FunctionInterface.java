package com.chiang.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8FunctionInterface {

	public static Java8FunctionInterface create(final Supplier<Java8FunctionInterface> supplier) {
		return supplier.get();
	}

	public static void collide(final Java8FunctionInterface car) {
		System.out.println("Collided " + car.toString());
	}

	public void follow(final Java8FunctionInterface another) {
		System.out.println("Following the " + another.toString());
	}

	public void repair() {
		System.out.println("Repaired " + this.toString());
	}

	public static void main(String[] args) {
		final Java8FunctionInterface car = Java8FunctionInterface.create(Java8FunctionInterface::new);
		final List<Java8FunctionInterface> cars = Arrays.asList(car);
		List names = new ArrayList();
		names.add("Google");
		names.add("Runnoob");
		names.add("Taobao");
		names.add("Baidu");
		names.add("Sina");
		names.forEach(System.out::println);
	}
}
