package com.lec.ex6_person;

public class personTestMain {
	public static void main(String[] args) {
		int i = 10;
		int[] arr = new int [3];
		arr[0] = 10; arr[1]=20; arr[2]=30;
		PersonInfo p1 = new PersonInfo("ȫ�浿", 20, 'm');
		//PersonInfo[]  person = {new PersonInfo("ȫ���", 20, 'm'),p1, new PersonInfo("�ű浿", 33, 'm')};
		PersonInfo[] person = new PersonInfo[3];
		person[0] = new PersonInfo("ȫ���", 22, 'f');
		person[1] = p1;
		person[2] = new PersonInfo("�ű浿", 33, 'm');
		for (int idx=0; idx<person.length; idx++) {
			System.out.println(person[idx].infoPrint());
			System.out.println("--------------");
		}
		for (PersonInfo p: person) {
			//p.print();
			System.out.println(p.infoPrint());
			System.out.println("~~~~~~~~~~~~");
			
		}
		
		/*PersonInfo p1;
		p1 = new PersonInfo("ȫ�浿", 22, 'm');
		p1.print();
		PersonInfo p2 = new PersonInfo();
		System.out.println(p2.infoPrint());*/
	}

}
