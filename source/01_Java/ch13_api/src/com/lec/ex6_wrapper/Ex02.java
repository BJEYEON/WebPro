package com.lec.ex6_wrapper;
//���ڿ�("100") -> ����(100)Integer.parseInt(���ڿ�)
//����(100) -> ���ڿ�("100") String.valueof
public class Ex02 {
	public static void main(String[] args) {
		System.out.println("��Ʈ���� ������ ��ȯ");
		int i = Integer.parseInt("100");
		System.out.println("i = " + i);
		String str_Month = String.valueOf(12);
		str_Month = "" + 12; //"12"
	}

}
