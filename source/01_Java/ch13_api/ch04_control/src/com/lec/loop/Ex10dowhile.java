package com.lec.loop;

import java.util.Scanner;

//¦���� �Է¹޾� ���(¦���� �ƴϸ� ¦���� �ٽ��Է¹���)
public class Ex10dowhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.println("¦���� �Է��ϼ���: ");
			num = scanner.nextInt();
		}while(num%2 != 0);
		System.out.println("�Է��Ͻ� ����" + num);
		scanner.close();
		
		
	}

}
