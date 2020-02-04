package com.chiang.inter.entity;

import com.chiang.inter.ICar;
import com.chiang.inter.IDriver;

public class Driver implements IDriver {

	@Override
	public void drive(ICar car) {
		car.run();
	}

}
