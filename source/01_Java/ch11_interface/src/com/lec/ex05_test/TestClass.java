package com.lec.ex05_test;
//i1, m1(�߻�), i2,m2(�߻�), i3, m3(�߻�)
public class TestClass implements I3{

	@Override
	public void m1() {
		System.out.println("���i1 = " + i1);
	}

	@Override
	public void m2() {
		System.out.println("���i2 = " + i2);
	}

	@Override
	public void m3() {
		System.out.println("��� i3 = " + i3);
	}

}
