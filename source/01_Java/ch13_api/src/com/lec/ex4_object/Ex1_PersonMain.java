package com.lec.ex4_object;

import com.lec.ex2_date.SawonQuiz;

public class Ex1_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9810211173721L);
		Person p2 = new Person(9810211173721L);
		Person p3 = null;
		SawonQuiz s = new SawonQuiz("1", "박", "COM");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2는" + (p1==p2));
		System.out.println("p1과p2가 같냐:" + p1.equals(p2));
		System.out.println("p1과p3가 같냐:" + p1.equals(p3));
		System.out.println("p2과s가 같냐:" + p2.equals(s));
	}
	
}
