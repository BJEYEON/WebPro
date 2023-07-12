package com.lec.ex1_string;
// string의 단점을 보완하고자 stringBuffer> StringBuilder

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드" + strBuffer.hashCode());
		strBuffer.append("def");//abcdef
		System.out.println("append 후" + strBuffer);
		System.out.println("append 후 해쉬코드" + strBuffer.hashCode());
		strBuffer.delete(3, 5);
		System.out.println("append 후" + strBuffer);
		System.out.println("append 후 해쉬코드" + strBuffer.hashCode());
	}

}
