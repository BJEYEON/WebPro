package com.lec.ex05_test;
//i1,i2,i3,m1(),m2(),m3()/ i11, m11(추상)
public class TestChildClass extends TestClass implements I11{

	@Override
	public void m11() {
		System.out.println("상수 i11 = " + i11);
	}

}
