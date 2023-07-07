package com.lec.quiz;

public abstract class Employee {
	private String name;
	public Employee(String name) {
		this.name = name;
	}
	public abstract int computePay(); //월급인데 바뀔수도있으니 추상변수
	public final int computeIncentive() {// 인센티브(final오버라이드금지)
		int temp = computePay();
		if (temp>=300000) {
			return (int)(temp*0.05);
		}
		return 0;
		//return temp>=300000 ? (int)(temp*0.05) : 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
