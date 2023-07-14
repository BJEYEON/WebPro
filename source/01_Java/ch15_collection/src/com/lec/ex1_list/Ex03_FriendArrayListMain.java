package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

public class Ex03_FriendArrayListMain {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999", new Date(98,0,1)));
		friends.add(new Friend("김길동", "010-8888-8888", new Date(98,6,4)));
		friends.add(new Friend("마길동", "010-7777-7777", new Date(98,6,4)));
		friends.add(new Friend("박길동", "010-6666-8888", new Date(98,5,14)));
		friends.add(new Friend("윤길동", "010-5555-7777", new Date(98,11,4)));
		for (Friend friend : friends) {
			System.out.println(friend);
		}
		for (int i=0; i<friends.size(); i++) {
			System.out.println(i + ":" + friends.get(i));
		}
		//0번 인덱스 부터 끝까지 이름을 출력하세요(확장 for문, 일반for문)
		for (Friend friend : friends) {
			System.out.println(friend.getName());
		}
		for (int i=0; i<friends.size(); i++) {
			System.out.println(friends.get(i).getName());
		}
	}

}
