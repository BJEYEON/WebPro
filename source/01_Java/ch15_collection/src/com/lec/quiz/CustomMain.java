package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

// N(n)를 입력할 때 까지 고객이름, 전화, 주소를 입력받아 arrayList add
// N(n)를 입력하면 가입한 고객정보 출력(arrayList for문을 출력)
public class CustomMain {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		String name, tel, adrress, answer;
		// N(n)를 입력할 때 까지 고객이름, 전화, 주소를 입력받아 arrayList add
		while(true) {
			System.out.println("회원가입을 진행하겠습니까(Y/N)?");
			answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("n")) break;
			//"이름, 전화번호, 주소 입력받아 customer객체 만들어 customer.add하기");
			System.out.print("이름?");
			name = scanner.nextLine();
			System.out.print("전화?");
			tel = scanner.nextLine();
			System.out.print("주소?");
			adrress = scanner.nextLine();
			
			customers.add(new Customer(name, tel, adrress));
//			Customer customer = new Customer();//customer.name tel = null
//			System.out.print("이름?");
//			customer.setName(scanner.nextLine());
//			System.out.print("전화?");
//			customer.setTel(scanner.nextLine());
//			System.out.print("주소?");
//			customer.setAddress(scanner.nextLine());
//			customers.add(customer);

		}
		// N(n)를 입력하면 가입한 고객정보 출력(arrayList for문을 출력)
		if (customers.size()==0) {
			System.out.println("가입한 회원이 없습니다");
		}
		else {
			for (Customer customer : customers) {
				System.out.println(customer);
			}
			//customers 출력 (확장for문, 일반for문 모두 가능)
		}

	}

}
