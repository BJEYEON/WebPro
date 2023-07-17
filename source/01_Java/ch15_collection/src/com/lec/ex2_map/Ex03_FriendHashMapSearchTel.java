package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.lec.ex1_list.Friend;

public class Ex03_FriendHashMapSearchTel {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010-9999-9999", new Friend("ȫ�浿", "010-9999-9999", new Date(98, 0, 1)));
		friends.put("010-8888-8888", new Friend("��浿", "010-8888-8888", new Date(98, 6, 14)));
		friends.put("010-7777-7777", new Friend("�ű浿", "010-7777-7777", new Date(98, 6, 17)));
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("�˻��� ��ȭ��ȣ�� (����:x) ?");
			String searchTel = scanner.next();
			if (searchTel.equalsIgnoreCase("x"))
				break;
			Friend searchResult = friends.get(searchTel);
			if (friends.get(searchTel) != null) {
				System.out.println("�˻����:" + friends.get(searchTel));
			}
			else {
				System.out.println("�˻��� ��ȭ��ȣ�� ���� �����Դϴ�.");
			}
		}
	}

}
