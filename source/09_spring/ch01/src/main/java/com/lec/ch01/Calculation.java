package com.lec.ch01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {
	private int num1;
	private int num2;
	public void add() {
		System.out.println("더하기\t");
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));
	}
	public void sub() {
		System.out.println("빼기\t");
		System.out.println(num1 + "-" + num2 + "=" + (num1-num2));
	}
	public void mul() {
		System.out.println("곱하기\t");
		System.out.println(num1 + "*" + num2 + "=" + (num1*num2));
	}
	public void div() {
		System.out.println("나누기\t");
		System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
	}
}
