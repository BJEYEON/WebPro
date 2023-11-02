package com.lec.ch02.ex4_vehicle;

import lombok.Data;

@Data
public class VehicleImpl implements Vehicle {
	private String vehicle;
	private int speed;
	public void ride(String name) {
		System.out.println(name + "은 " + vehicle + "를" +  speed + "로간다");

	}

}
