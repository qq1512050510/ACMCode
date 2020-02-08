package com.chiang.inter.entity;

import com.chiang.inter.ICar;
import com.chiang.inter.IDriver;

public class Driver implements IDriver {
	static final int MAXIMUM_CAPACITY = 1 << 30;
	@Override
	public void drive(ICar car) {
		car.run();
	}
	
	public static void main(String[] args) {
		System.out.println(MAXIMUM_CAPACITY);
		Driver driver = new Driver();
		System.out.print(driver.MAXIMUM_CAPACITY);
	}

}
