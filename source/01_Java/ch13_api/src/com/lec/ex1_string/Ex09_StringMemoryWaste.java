package com.lec.ex1_string;

public class Ex09_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, java";
		//str�� �ּ�(x) -> �ؽ��ڵ�� ��ü
		System.out.println(str.hashCode());
		str = "Hello, JAVA";
		System.out.println(str.hashCode());
		str = "Hello, C";
		System.out.println(str.hashCode());
	}

}
