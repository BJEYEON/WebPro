package com.lec.ex3_product;
//데이터: 시리얼 넘버
//product p = new Product(1);
//main에서 Product p1 = new Product();
public class Product {
	private int serialNo;
	public static int count = 100;
	public Product() {
		serialNo = ++count;
	}
	public static void staticMethod() {
		//System.out.println("static메소드");
	}
	public void infoPrint() {
		//System.out.println("시리얼번호: " + serialNo + "\t공유변수 count: " + count);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
