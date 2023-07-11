package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str4 = new String ("abcXabc");
		String str2 = "                Ja va              ";
		System.out.println("1. " + str1.concat(str2));//+
		System.out.println("2. " + str1.substring(3));
		System.out.println("3. " + str1.substring(3,5));
		System.out.println("4. " + str1.length());
		System.out.println("5. " + str1.toUpperCase());//전부대문자
		System.out.println("6. " + str1.toLowerCase());//전부소문자
		System.out.println("7. " + str1.charAt(3));//3번째 글자가져와
		System.out.println("8. " + str1.indexOf("b"));//처음나오는b의인덱스
		System.out.println("9. " + str1.lastIndexOf("b"));
		System.out.println("10. " + str1.indexOf("@"));
		System.out.println("11. " + str1.indexOf("Xab"));
		String str3 = "abcXabcXabc";
		System.out.println("12. " + str3.indexOf("b", 2));//두번째 문자부터 찾음
		System.out.println("13. " + str1.equals(str4));
		System.out.println("14. " + str1.equalsIgnoreCase("ABCXABC"));// 대소문자 구분없이 같은지 비교
		System.out.println("15. " + str2.trim());
		System.out.println("16. " + str3.replace("abc", "바꿔"));
	}

}
