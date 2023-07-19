package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		HashMap<String, Member> member = new HashMap<>();
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, str_birth, address;
		Date birth;
		OutputStream os = null;
		String str_Out = "";
		while (true) {
			System.out.println("회원 가입하실래요(단, 원치않으면 n)?");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.println("이름?");
			name = scanner.next();
			System.out.println("전화?");
			tel = scanner.next();
			System.out.println("생일(yyyy-MM-dd)?");
			str_birth = scanner.next();
			birth = toDate(str_birth);
			// birth = toDateDateTodayIsBirthDayChk(str_birth);
			System.out.println("주소?");
			address = scanner.next();
			// member에add

			members.add(new Member(name, tel, birth, address));
			

		}//while
		if (members.size() == 0) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			for (int i = 0; i < members.size(); i++) {
				str_Out += members.get(i) + "\n";
			}
			System.out.println(str_Out);
			try {
				os = new FileOutputStream("txtFile/member.txt");
				str_Out += "\n...이하" + members.size() + "명 가입"; 
				byte[] bs = str_Out.getBytes();
				os.write(bs); 
			} catch (FileNotFoundException e) {
				System.out.println("파일 못찾음" + e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if (os!=null) os.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}//if

	}//main

	private static Date toDate(String str_birth) {
		// 매개변수로 들어온 "1995-01-01"을 date형으로 변환하여return
		Date result = null;
		Date now = new Date();
		SimpleDateFormat asd = new SimpleDateFormat("MM-dd");
		String str_Now = asd.format(now);
		StringTokenizer tokenizer = new StringTokenizer(str_birth, "-");
		if (tokenizer.countTokens() == 3) {
			// 제대로 입력
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			if (str_birth.substring(5).equals(str_Now)) {
				System.out.println("생일을 축하합니다.");
			}
		} else {
			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다.");
		}
		
		return result;
	}

}
