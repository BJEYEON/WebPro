package com.lec.ex1_string;

import java.util.Scanner;

//<����.�ֹι�ȣ�� �Է¹޾� �������� �������� ��� ����> �ֹι�ȣ�� ��920225-2012121���������� �Է¹޴´�.
public class Ex04_Quiz1 {
	public static void main(String[] args) {
		String num;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���.");
		num = scanner.next();
		System.out.println(Integer.parseInt(num.substring(7, 8)));
		if (num.indexOf("-") == -1 || Integer.parseInt(num.substring(7, 8)) >=5) {
			System.out.println("�߸��Է��߽��ϴ�.");
			
		}//if
		else if (Integer.parseInt(num.substring(7, 8)) == 1 ||Integer.parseInt(num.substring(7, 8)) == 3) {
			System.out.println("�����Դϴ�.");
			
		}
		else if (Integer.parseInt(num.substring(7, 8)) == 2 ||Integer.parseInt(num.substring(7, 8)) == 4) {
			System.out.println("�����Դϴ�");
		}
			
		
		
	}

}
