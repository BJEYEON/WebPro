package com.lec.ex2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String,Friend> friend = new HashMap<String, Friend>();
		friend.put("010-9999-9999", new Friend ("ȫ�浿", "010-9999-9999"));
		friend.put("010-8888-8888", new Friend("��浿", "010-8888-8888", new Date(98,6,14)));
		friend.put("010-7777-7777", new Friend("�ű浿", "010-7777-7777", new Date(98,6,17)));
		Iterator<String> iterator = friend.keySet().iterator();// ��¿� �ʿ��� �ݺ���
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + ":" + friend.get(key));
		}
	}

}
