package com.lec.ex2person_dtoDao;

import java.util.ArrayList;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		System.out.println("직업명들: " + dao.janameList());
		System.out.println("1. 기능 insert 테스트");
		PersonDto dto = new PersonDto("홍홍홍", "배우", 70, 80, 90);
//		int result = dao.insertPerson(dto);
//		System.out.println(result == PersonDao.SUCCESS? "입력성공": "입력실패");
		System.out.println("2. 배우 직업별 출력");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		if (dtos.isEmpty()) {
			System.out.println("배우 직업의 사람이 등록되지 않았습니다");
		} else {
			for (PersonDto d : dtos) {
				System.out.println(d);
			}
			System.out.println("총" + dtos.size() + "명");
		}
		System.out.println("2. 개그맨 직업별 출력");
		dtos = dao.selectJname("개그맨");
		if (dtos.isEmpty()) {
			System.out.println("개그맨 직업의 사람이 등록되지 않았습니다");
		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx));
			}
		}
		System.out.println("3. 전체 출력 테스트");
		dtos = dao.selectALL();
		if (dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
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
