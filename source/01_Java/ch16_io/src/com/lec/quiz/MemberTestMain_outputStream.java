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
			System.out.println("ȸ�� �����ϽǷ���(��, ��ġ������ n)?");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.println("�̸�?");
			name = scanner.next();
			System.out.println("��ȭ?");
			tel = scanner.next();
			System.out.println("����(yyyy-MM-dd)?");
			str_birth = scanner.next();
			birth = toDate(str_birth);
			// birth = toDateDateTodayIsBirthDayChk(str_birth);
			System.out.println("�ּ�?");
			address = scanner.next();
			// member��add

			members.add(new Member(name, tel, birth, address));
			

		}//while
		if (members.size() == 0) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			for (int i = 0; i < members.size(); i++) {
				str_Out += members.get(i) + "\n";
			}
			System.out.println(str_Out);
			try {
				os = new FileOutputStream("txtFile/member.txt");
				str_Out += "\n...����" + members.size() + "�� ����"; 
				byte[] bs = str_Out.getBytes();
				os.write(bs); 
			} catch (FileNotFoundException e) {
				System.out.println("���� ��ã��" + e.getMessage());
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
		// �Ű������� ���� "1995-01-01"�� date������ ��ȯ�Ͽ�return
		Date result = null;
		Date now = new Date();
		SimpleDateFormat asd = new SimpleDateFormat("MM-dd");
		String str_Now = asd.format(now);
		StringTokenizer tokenizer = new StringTokenizer(str_birth, "-");
		if (tokenizer.countTokens() == 3) {
			// ����� �Է�
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			if (str_birth.substring(5).equals(str_Now)) {
				System.out.println("������ �����մϴ�.");
			}
		} else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�.");
		}
		
		return result;
	}

}
