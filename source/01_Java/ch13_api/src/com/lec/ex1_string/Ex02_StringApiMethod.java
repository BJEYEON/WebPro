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
		System.out.println("5. " + str1.toUpperCase());//���δ빮��
		System.out.println("6. " + str1.toLowerCase());//���μҹ���
		System.out.println("7. " + str1.charAt(3));//3��° ���ڰ�����
		System.out.println("8. " + str1.indexOf("b"));//ó��������b���ε���
		System.out.println("9. " + str1.lastIndexOf("b"));
		System.out.println("10. " + str1.indexOf("@"));
		System.out.println("11. " + str1.indexOf("Xab"));
		String str3 = "abcXabcXabc";
		System.out.println("12. " + str3.indexOf("b", 2));//�ι�° ���ں��� ã��
		System.out.println("13. " + str1.equals(str4));
		System.out.println("14. " + str1.equalsIgnoreCase("ABCXABC"));// ��ҹ��� ���о��� ������ ��
		System.out.println("15. " + str2.trim());
		System.out.println("16. " + str3.replace("abc", "�ٲ�"));
	}

}
