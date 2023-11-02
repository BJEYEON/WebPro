package com.lec.ch03;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobby;
	private double height;
	private double weight;
	public Student(String name, int age, ArrayList<String> hobby) {
		super();
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "이름:" + name + ", 나이:" + age + ", 취미:" + hobby + ", 키:" + height + ", 몸무게:"
				+ weight;
	}
}
