package com.lec.ex1_string;
// string�� ������ �����ϰ��� stringBuffer> StringBuilder

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer�� �ؽ��ڵ�" + strBuffer.hashCode());
		strBuffer.append("def");//abcdef
		System.out.println("append ��" + strBuffer);
		System.out.println("append �� �ؽ��ڵ�" + strBuffer.hashCode());
		strBuffer.delete(3, 5);
		System.out.println("append ��" + strBuffer);
		System.out.println("append �� �ؽ��ڵ�" + strBuffer.hashCode());
	}

}
