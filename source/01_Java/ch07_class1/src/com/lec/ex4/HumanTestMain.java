package com.lec.ex4;

import com.lec.ex4_human.*;
import com.lec.ex4_human.kid.Kid;

public class HumanTestMain {
	public static void main(String[] args) {
		Woman woman1 = new Woman();
		Woman woman2 = new Woman();
		System.out.println("woman1과 woman2가 같은지:" + (woman1 == woman2)); //비추
		System.out.println("woman1과 woman2가 같은지:" + woman1.equals(woman2));
		
		Man man = new Man();
		Kid kid = new Kid("홍아가");
		//Kid kid2 = new Kid();
		Man kim = new Man("홍길동", 22, 170, 59.0);
		Man sin = new Man("신길동");
		Man kim2 = kim;
		System.out.println("Kim과Kim2가 같은지 여부:" + kim.equals(kim2));
		sin.setHeight(165);
		sin.setWeight(57);
		System.out.println("kim의 bmi지수: " + kim.calculateBMI());
		System.out.println("sim의 bmi지수: " + sin.calculateBMI());
	}
}

