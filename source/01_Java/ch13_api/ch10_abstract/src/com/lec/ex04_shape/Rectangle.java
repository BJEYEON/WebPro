package com.lec.ex04_shape;

public class Rectangle  extends Shape{
	private int w;
	private int h;
	public Rectangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	@Override
	public double area() {
		return w*h;
	}
	@Override
	public void draw() {
		System.out.print("�簢��");
		super.draw();
	}

}
