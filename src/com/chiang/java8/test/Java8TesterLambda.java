package com.chiang.java8.test;

import java.util.ArrayList;
import java.util.List;

public class Java8TesterLambda {

	public static void main(String[] args) {

		// 类型声明
		MathOperation addition = (int a, int b) -> a + b;

		// 不用类型声明
		MathOperation substraction = (a, b) -> a - b;

		// 大括号中的返回语句
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// 没有大括号以及返回语句
		MathOperation division = (int a, int b) -> a / b;

		Java8TesterLambda java8TesterLambda = new Java8TesterLambda();
		System.out.println("10+5=" + java8TesterLambda.operate(10, 5, addition));
		System.out.println("10-5=" + java8TesterLambda.operate(10, 5, substraction));
		System.out.println("10*5=" + java8TesterLambda.operate(10, 5, multiplication));
		System.out.println("10/5=" + java8TesterLambda.operate(10, 5, division));

		List<Integer> m = new ArrayList();

		m.forEach(mOne -> System.out.println(mOne));
		// 不用括号
		GreetingService greetingService1 = message -> System.out.println("Hello1 " + message);
		// 用括号
		GreetingService greetingService2 = (message) -> System.out.println("Hello2 " + message);
		
		greetingService1.sayMessage("Runoob");
		greetingService2.sayMessage("google");
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
		//void sayHello(String hello);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
