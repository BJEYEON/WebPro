package com.lec.ex2person_dtoDao;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		System.out.println("�������: " + dao.janameList());
		System.out.println("1. ��� insert �׽�Ʈ");
		PersonDto dto = new PersonDto("ȫȫȫ", "���", 70, 80, 90);
//		int result = dao.insertPerson(dto);
//		System.out.println(result == PersonDao.SUCCESS? "�Է¼���": "�Է½���");
		System.out.println("2. ��� ������ ���");
		ArrayList<PersonDto> dtos = dao.selectJname("���");
		if (dtos.isEmpty()) {
			System.out.println("��� ������ ����� ��ϵ��� �ʾҽ��ϴ�");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
			System.out.println("��" + dtos.size() + "��");
		}
		System.out.println("2. ���׸� ������ ���");
		dtos = dao.selectJname("���׸�");
		if (dtos.isEmpty()) {
			System.out.println("���׸� ������ ����� ��ϵ��� �ʾҽ��ϴ�");
		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx));
			}
		}
		System.out.println("3. ��ü ��� �׽�Ʈ");
		dtos = dao.selectALL();
		if (dtos.isEmpty()) {
			System.out.println("��ϵ� ����� �����ϴ�.");
		}else {
			for (int i=0; i<dtos.size(); i++) {
				System.out.println(dtos.get(i));
				if (i%3==2) {
					System.out.println("---------------------------");
				}//if
			}//for
		}//else
	}
}
