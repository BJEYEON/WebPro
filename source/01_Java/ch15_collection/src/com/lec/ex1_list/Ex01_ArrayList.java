package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];		
		array[0] = "str0"; array[1]= "str1"; array[2] = "str2";
		System.out.println(Arrays.toString(array));
		for (String arr : array) {
			System.out.println(arr);
		}
		for (int i=0; i<array.length; i++) {
			System.out.println(i+ "�� �ε��� ��:" + array[i]);
		}
		System.out.println("===========ArrayList===========");
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("str0");//0�� �ε���
		arrayList.add("str1");//1�� �ε���->2���ε���
		arrayList.add("str2");//2�� �ε���->3���ε���
		arrayList.add(1, "str1111"); //1���ε���
		arrayList.set(2, "str2222");//2�� �ε��� ����
		System.out.println("arrayList�� ������:" + arrayList.size());
		arrayList.add("str4");
		System.out.println("arrayList�� ������:" + arrayList.size());
		System.out.println(arrayList);
		for (String temp: arrayList) {
			System.out.println(temp);
			
		}
		for (int i=0; i<arrayList.size(); i++) {
			System.out.println(i + "�� �ε��� ��:" + arrayList.get(i));// array[i]
		}
		//arrayList.remove(2);//2�� �ε����� ���� ����(3���ε���->2���ε�����, 4���ε�����3���ε�����
		arrayList.remove("str2222");// "str2222"������
		arrayList.remove(arrayList.size()-1);//�Ǹ����� �ε��� �� ����
		System.out.println("2�� �ε��� ��, �� ������ �ε����� remove��");
		for (int i=0; i<arrayList.size(); i++) {
			System.out.println(i + "�� �ε��� ��:" + arrayList.get(i));// array[i]
		}
		arrayList.clear();// arrayList�� ��絥���� ����
		System.out.println(arrayList.size()==0? "������ ���� �Ϸ�": "������ ����");
		System.out.println(arrayList.isEmpty()? "������ ���� �Ϸ�": "������ ����");
		//arrayList = null;
	}

}
