package com.lec.ex04_shape;

import cons.Constant;

public class Circle extends Shape{
	private int r;
	public Circle() {}
	public Circle(int r) {
		this.r = r;
	}
	@Override
	public double area() {
		return Constant.PI * r * r;
	}
	@Override
	public void draw() {
		System.out.print("��");
		super.draw();
	}
	
}
