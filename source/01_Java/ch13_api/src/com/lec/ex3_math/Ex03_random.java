package com.lec.ex3_math;

import java.util.Random;

//0<=Math.random()<1
// 0<= Math.random()*3 < 3�Ǽ�
//0 <= (int)(Math.random()*3)<3����
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1~45������ ���� ����:" + ((int)(Math.random()*45) + 1));
		System.out.println("0~2������ ���� ����:" + (int)(Math.random()*3));
		Random random = new Random();
		System.out.println("int ���� ����: " + random.nextInt());
		System.out.println("double �Ǽ� ����:" + random.nextDouble());
		System.out.println("true/false����" + random.nextBoolean());
		System.out.println("0~100 ���� ����:" + random.nextInt(101));
		System.out.println("0~2��������" + random.nextInt(3));
		System.out.println("1~45���� ����:" + (random.nextInt(45)+1));
		
	}

}
