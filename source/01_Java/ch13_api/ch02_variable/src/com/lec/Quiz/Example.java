package com.lec.Quiz;

public class Example {
	public static void main(String[] args) {
		int kor = 90;
		int eng = 80;
		int math = 70;
		int total;
		total = kor + eng + math; //����
		System.out.println("��������: " + math + "��");
		System.out.println("��������: " + eng + "��");
		System.out.println("��������: " + kor + "��");
		System.out.println("������: " + (double)total/3 + "��");
		
		System.out.print("��������: " + math + "��");
		System.out.print("��������: " + eng + "��");
		System.out.print("��������: " + kor + "��");
		System.out.print("������: " + (double)total/3 + "��");
		
		System.out.print("��������: " + math + "��");
		System.out.print("��������: " + eng + "��");
		System.out.print("��������: " + kor + "��");
		System.out.print("������: " + (double)total/3 + "��");
		
		System.out.printf("\r\n��������=%d", math);
		System.out.printf("\r\n��������=%d", eng);
		System.out.printf("\r\n��������=%d", kor);
		System.out.printf("\r\n������=%f", total/3.0);
	}

}
