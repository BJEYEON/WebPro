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
			System.out.println("회원가입을 진행하겠습니까(Y/N)?");
			yn = scanner.nextLine();
			if (yn.equalsIgnoreCase("n")) break;
			System.out.println("이름?");
			name = scanner.nextLine();
			System.out.println("전화?");
			tel = scanner.nextLine();
			System.out.println("주소?");
			address = scanner.nextLine();
			custom.put(tel, new CustomerHashMap(name, tel, address));
		}//while
		if (custom.size() == 0) {
			System.out.println("가입한 회원이 없습니다");
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
