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
		friends.add(new Friend("������", "���� ����", "010-8721-9496", new Date(new GregorianCalendar(1998,10,21).getTimeInMillis())));
		friends.add(new Friend("�ڼҿ�", "���� ����", "010-7135-9493", new Date(02,1,20)));
		friends.add(new Friend("ȫ�浿", "��� ���籸", "010-8721-9496", new Date(99,1,21)));
		friends.add(new Friend("��浿", "�泲 û�ֽ�", "010-7777-7777", new Date(22,12,21)));
		friends.add(new Friend("�ڱ浿", "�λ� ������", "010-8888-8888", new Date(14,11,21)));

		while (true) {
			int num = 0;
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			br = scanner.next();
			if (br.equalsIgnoreCase("x")) break;
			
			for (int i=0; i<friends.size(); i++) {
	
				if ( (friends.get(i).getAddress().substring(0,2) ).equals(br)) {
					System.out.println(friends.get(i));
					num++;
				}
			}
			if (num == 0) {
				System.out.println("���� ������ ��� ģ���� �����ϴ�.");
			}
		}

	}//main

	private static String GregorianCalendar(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
