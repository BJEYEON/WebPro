package com.lec.ex6_wrapper;

import com.lec.ex4_object.Card;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		Integer iObj = 10; //new Integer(10);�ڵ�����
		Double dObj = 2.2; // new Double(2.2)�ڵ�����
		i = iObj;
		Card c1 = new Card("��Ʈ", 3);
		StringBuffer s = new StringBuffer("s");
		System.out.println(c1.equals(i));
	}

}
