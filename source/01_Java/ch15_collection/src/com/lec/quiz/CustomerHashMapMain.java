package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerHashMapMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String,CustomerHashMap> custom = new HashMap<String, CustomerHashMap>();
		String name, tel, address, yn;
		while (true) {
			System.out.println("ȸ�������� �����ϰڽ��ϱ�(Y/N)?");
			yn = scanner.nextLine();
			if (yn.equalsIgnoreCase("n")) break;
			System.out.println("�̸�?");
			name = scanner.nextLine();
			System.out.println("��ȭ?");
			tel = scanner.nextLine();
			System.out.println("�ּ�?");
			address = scanner.nextLine();
			custom.put(tel, new CustomerHashMap(name, tel, address));
		}//while
		if (custom.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�");
		}
		else {
			Iterator<String> iterator = custom.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(custom.get(key));
				
			}
		}
		
	}//main

}
