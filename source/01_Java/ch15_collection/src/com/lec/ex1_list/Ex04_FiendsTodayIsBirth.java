package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FiendsTodayIsBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("홍길동", "010-9999-9999", new Date(98,0,1)));
		friends.add(new Friend("김길동", "010-8888-8888", new Date(98,6,14)));
		friends.add(new Friend("마길동", "010-7777-7777", new Date(98,6,14)));
		friends.add(new Friend("박길동", "010-6666-8888", new Date(98,5,14)));
		friends.add(new Friend("윤길동", "010-5555-7777", new Date(98,11,4)));
		//오늘이 생일인 친구만 출력
		System.out.println("오늘이 생일인 친구는?");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String str_Now = sdf.format(now);//"07-14"
		boolean searchOk = false;
		for (Friend friend : friends) {
			Date birth = friend.getBirth();
			if (birth!=null &&sdf.format(birth).equals(str_Now)) {
				System.out.println("\n" + friend);
				searchOk = true;//생일인 친구 찾음
			}//if
		}//for
		if(!searchOk) {
			System.out.println("오늘 생일자가 없습니다");
		}
	}//main

}
