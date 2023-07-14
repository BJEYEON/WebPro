package com.lec.ex1_list;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ex04_FiendsTodayIsBirth {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999", new Date(98,0,1)));
		friends.add(new Friend("��浿", "010-8888-8888", new Date(98,6,14)));
		friends.add(new Friend("���浿", "010-7777-7777", new Date(98,6,14)));
		friends.add(new Friend("�ڱ浿", "010-6666-8888", new Date(98,5,14)));
		friends.add(new Friend("���浿", "010-5555-7777", new Date(98,11,4)));
		//������ ������ ģ���� ���
		System.out.println("������ ������ ģ����?");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String str_Now = sdf.format(now);//"07-14"
		boolean searchOk = false;
		for (Friend friend : friends) {
			Date birth = friend.getBirth();
			if (birth!=null &&sdf.format(birth).equals(str_Now)) {
				System.out.println("\n" + friend);
				searchOk = true;//������ ģ�� ã��
			}//if
		}//for
		if(!searchOk) {
			System.out.println("���� �����ڰ� �����ϴ�");
		}
	}//main

}
