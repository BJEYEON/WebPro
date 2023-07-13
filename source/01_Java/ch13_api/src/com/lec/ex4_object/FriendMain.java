package com.lec.ex4_object;
// 생일(MM-dd)검색
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("홍", "010-9999-9999", "서울시 서대문구",
						new Date(new GregorianCalendar(1998, 11, 12).getTimeInMillis())),
				new Friend("신길동", "010-8888-8888", "서울마포구",
						new Date(new GregorianCalendar(1996, 6, 22).getTimeInMillis())),
				new Friend("김길동", "010-9999-1111", "인천중구",
						new Date(new GregorianCalendar(1996, 6, 22).getTimeInMillis())),
				new Friend("박성광", "010-8888-9999", "서울용산구",
						new Date(new GregorianCalendar(1996, 7, 22).getTimeInMillis())),
				new Friend("윤동주", "010-8888-5555", "함북 청진시",
						new Date(new GregorianCalendar(1996, 1, 22).getTimeInMillis())) };
		Scanner scanner = new Scanner(System.in);
		// 검색할 생일 입력(07-22) =>배열검색(0번째 인덱스 부터 생일중에 MM-dd만 추출한 정보를 비교후 같으면 출력)
		while (true) {
			boolean searchOk = false;// 못찾았다를 초기화
			System.out.print("검색할 생일을 MM-dd로 입력 (단, 종료를 원하시면 x를 입력하시오): ");
			String searchWord = scanner.next();
			if (searchWord.equalsIgnoreCase("x"))
				break;
			for (Friend friend : friends) {
				Date birth = friend.getBirthday();
				SimpleDateFormat dfg = new SimpleDateFormat("MM-dd");
				String str_Birth = dfg.format(birth);
				if (searchWord.equals(str_Birth)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if (searchOk == false) {
				System.out.println("해당 생일의 친구는 없습니다");
			} // if
		} // while
	}// main

}