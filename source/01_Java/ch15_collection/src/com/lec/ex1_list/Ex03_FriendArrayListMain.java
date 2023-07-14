package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

public class Ex03_FriendArrayListMain {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999", new Date(98,0,1)));
		friends.add(new Friend("��浿", "010-8888-8888", new Date(98,6,4)));
		friends.add(new Friend("���浿", "010-7777-7777", new Date(98,6,4)));
		friends.add(new Friend("�ڱ浿", "010-6666-8888", new Date(98,5,14)));
		friends.add(new Friend("���浿", "010-5555-7777", new Date(98,11,4)));
		for (Friend friend : friends) {
			System.out.println(friend);
		}
		for (int i=0; i<friends.size(); i++) {
			System.out.println(i + ":" + friends.get(i));
		}
		//0�� �ε��� ���� ������ �̸��� ����ϼ���(Ȯ�� for��, �Ϲ�for��)
		for (Friend friend : friends) {
			System.out.println(friend.getName());
		}
		for (int i=0; i<friends.size(); i++) {
			System.out.println(friends.get(i).getName());
		}
	}

}
