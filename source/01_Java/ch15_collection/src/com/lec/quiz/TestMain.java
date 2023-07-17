package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String br;
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("박제연", "서울 은평구", "010-8721-9496", new Date(new GregorianCalendar(1998,10,21).getTimeInMillis())));
		friends.add(new Friend("박소연", "서울 은평구", "010-7135-9493", new Date(02,1,20)));
		friends.add(new Friend("홍길동", "고양 덕양구", "010-8721-9496", new Date(99,1,21)));
		friends.add(new Friend("김길동", "충남 청주시", "010-7777-7777", new Date(22,12,21)));
		friends.add(new Friend("박길동", "부산 강서구", "010-8888-8888", new Date(14,11,21)));

		while (true) {
			int num = 0;
			System.out.println("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");
			br = scanner.next();
			if (br.equalsIgnoreCase("x")) break;
			
			for (int i=0; i<friends.size(); i++) {
	
				if ( (friends.get(i).getAddress().substring(0,2) ).equals(br)) {
					System.out.println(friends.get(i));
					num++;
				}
			}
			if (num == 0) {
				System.out.println("같은 지역에 사는 친구가 없습니다.");
			}
		}

	}//main

	private static String GregorianCalendar(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
