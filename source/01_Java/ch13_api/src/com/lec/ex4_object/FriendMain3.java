package com.lec.ex4_object;
// �˻��� ��ȭ��ȣ ��4�ڸ� �Է�
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FriendMain3 {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("ȫ", "010-9999-9999", "����� ���빮��",
						new Date(new GregorianCalendar(1998, 11, 12).getTimeInMillis())),
				new Friend("�ű浿", "010-8888-8888", "���︶����",
						new Date(new GregorianCalendar(1996, 6, 22).getTimeInMillis())),
				new Friend("��浿", "010-9999-1111", "��õ�߱�",
						new Date(new GregorianCalendar(1996, 6, 22).getTimeInMillis())),
				new Friend("�ڼ���", "010-8888-9999", "�����걸",
						new Date(new GregorianCalendar(1996, 7, 22).getTimeInMillis())),
				new Friend("������", "010-8888-5555", "�Ժ� û����",
						new Date(new GregorianCalendar(1996, 1, 22).getTimeInMillis())) };
		Scanner scanner = new Scanner(System.in);
		// �˻��� ���� =>�迭�˻�(0��° �ε��� ����  ���� ������ ���)
		while (true) {
			boolean searchOk = false;// ��ã�Ҵٸ� �ʱ�ȭ
			System.out.print("�˻��� ��ȭ��ȣ ���ڸ� �Է� (��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�): ");
			String searchWord = scanner.next();
			if (searchWord.equalsIgnoreCase("x"))
				break;
			for (Friend friend : friends) {
				String tel = friend.getTel();
				tel = tel.substring(tel.lastIndexOf("-")+1,tel.length());
				
//				Date birth = friend.getBirthday();
//				SimpleDateFormat dfg = new SimpleDateFormat("MM-dd");
//				String str_Birth = dfg.format(birth);
				if (searchWord.equals(tel)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if (searchOk == false) {
				System.out.println("�ش� ��ȣ�� ģ���� �����ϴ�");
			} // if
		} // while
	}// main

}