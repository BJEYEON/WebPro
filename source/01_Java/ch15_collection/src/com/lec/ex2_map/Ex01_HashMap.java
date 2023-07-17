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
		hashmap.put(11, "str1");// 11:key/"str1"데이터
		hashmap.put(11, "str11"); // hashmap에서는 key값이 유일한값
		hashmap.put(12, "str12");
		hashmap.put(33, "str22");
		hashmap.put(20, "str20");
		System.out.println(11 + "key값의 데이터는" + hashmap.get(11));
		System.out.println(11 + "key값의 데이터는" + hashmap.get(22));//key값이 없으면null
		hashmap.remove(33);//remove시 key값으로 제거
		System.out.println("33 키 제거 후 " + hashmap);
		System.out.println(hashmap.isEmpty() ? "데이터 없음" : "데이터 있음");
		hashmap.clear();
		System.out.println(hashmap.size()==0? "데이터 없음" : "데이터있음");
		//hashmap 데이터 출력
		hashmap.put(0, "Hong gildong");
		hashmap.put(10, "Kim gongil");
		hashmap.put(22, "Lee soonsin");
		hashmap.put(40, "Shin gildong");
		Iterator<Integer> iterator = hashmap.keySet().iterator();//hashmap의 key값으로 만들어진 반복자
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + "key의 데이터는" + hashmap.get(key));
		}


	}

}
