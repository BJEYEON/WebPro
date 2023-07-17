package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("str0"); list.add("str0");
		System.out.println(list.get(0) + "/" + list.get(1));
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(11, "str1");// 11:key/"str1"������
		hashmap.put(11, "str11"); // hashmap������ key���� �����Ѱ�
		hashmap.put(12, "str12");
		hashmap.put(33, "str22");
		hashmap.put(20, "str20");
		System.out.println(11 + "key���� �����ʹ�" + hashmap.get(11));
		System.out.println(11 + "key���� �����ʹ�" + hashmap.get(22));//key���� ������null
		hashmap.remove(33);//remove�� key������ ����
		System.out.println("33 Ű ���� �� " + hashmap);
		System.out.println(hashmap.isEmpty() ? "������ ����" : "������ ����");
		hashmap.clear();
		System.out.println(hashmap.size()==0? "������ ����" : "����������");
		//hashmap ������ ���
		hashmap.put(0, "Hong gildong");
		hashmap.put(10, "Kim gongil");
		hashmap.put(22, "Lee soonsin");
		hashmap.put(40, "Shin gildong");
		Iterator<Integer> iterator = hashmap.keySet().iterator();//hashmap�� key������ ������� �ݺ���
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "key�� �����ʹ�" + hashmap.get(key));
		}


	}

}
