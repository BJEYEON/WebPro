package com.lec.ex4_object;

public class Ex2_hashcode {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = new String("Hello");
		if (str1==str2) {
			System.out.println("주소가 같음(같은곳을 참조)");
		}
		else {
			System.out.println("주소가 다름(다른곳을 참조)");
		}
		if (str1.equals(str2)) {
			System.out.println("같은문자열");
		}

	}

}
