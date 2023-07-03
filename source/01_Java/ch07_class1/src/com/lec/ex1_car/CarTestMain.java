package com.lec.ex1_car;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("빨강");
		myPorsche.setCc(3000);//myPorsche.cc	= 3000;
		System.out.println(myPorsche.getColor() + "색 차:" + myPorsche.getCc() + "cc, 속도:" + myPorsche.getSpeed());
//		System.out.println(myPorsche.color + "색 차:" + myPorsche.cc + "cc, 속도:" + myPorsche.speed);
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		
		Car yourPorsch = new Car();
		yourPorsch.setColor("gray");//yourPorsch.color = "gray";
		yourPorsch.drive();
	}

}
