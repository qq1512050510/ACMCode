package com.chiang.collection;

import java.util.HashSet;
import java.util.Set;

public class Students {

	public static void main(String[] args) {
		Set students = new HashSet();
		students.add(new Student("Justin", "123"));
		students.add(new Student("Justin", "123"));
		students.add(new Student("Justin", "123"));
		students.add(123);
		System.out.println(students);
	}
}

class Student {
	private String name;
	private String number;

	Student(String name, String number) {
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("(%s,%s)", name, number);
	}
}
