package com.lec.ex3_product;

public class ProductTestMain {
	public static void main(String[] args) {
		//System.out.println("static 변수: " + Product.count);
		Product.staticMethod();
		Product p1 = new Product();
		//p1.infoPrint();
		//Product p2 = new Product();
		System.out.println("static 변수: " + Product.count);
		//p2.infoPrint();
		//Product p3 = new Product();
		//System.out.println("static 변수: " + Product.count);
		//System.out.println("static 변수: " + p1.count);
		//System
		//System.out.println("static 변수: " + p2.count);
	}

	
}

