package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		String s0 = "str0";
		String s1 = "str0";
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1");
		hashset.add("str2");
		System.out.println(hashset);
		System.out.println("hashset의 데이터 갯수:" + hashset.size());
		hashset.add("str2");
		System.out.println("중복 데이터add후:" + hashset);
		System.out.println("중복 데이터 add후 데이터 갯수:" + hashset.size());
		Iterator<String> iterator = hashset.iterator(); // hashset출력을 반복자
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
