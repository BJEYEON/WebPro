package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

// N(n)�� �Է��� �� ���� ���̸�, ��ȭ, �ּҸ� �Է¹޾� arrayList add
// N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
public class CustomMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String name, tel, adrress, answer;
		// N(n)�� �Է��� �� ���� ���̸�, ��ȭ, �ּҸ� �Է¹޾� arrayList add
		while(true) {
			System.out.println("ȸ�������� �����ϰڽ��ϱ�(Y/N)?");
			answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("n")) break;
			//"�̸�, ��ȭ��ȣ, �ּ� �Է¹޾� customer��ü ����� customer.add�ϱ�");
			System.out.print("�̸�?");
			name = scanner.nextLine();
			System.out.print("��ȭ?");
			tel = scanner.nextLine();
			System.out.print("�ּ�?");
			adrress = scanner.nextLine();
			//custom.add
			customers.add(new Customer(name, tel, adrress));
		}
		// N(n)�� �Է��ϸ� ������ ������ ���(arrayList for���� ���)
		if (customers.size()==0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}
		else {
			for (Customer customer : customers) {
				System.out.println(customer);
			}
			//customers ��� (Ȯ��for��, �Ϲ�for�� ��� ����)
		}

	}

}
