package com.lec.ch02.ex4_vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class VehicleTestMain {
	public static void main(String[] args) {
		//Bicycle bicycle = new Bicycle();
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX4.xml");
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		vh.ride("홍길동");
		ctx.close();
	}
}
