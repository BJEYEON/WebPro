package com.lec.ex1_string;

public class Ex11_speedCheck {
	public static void main(String[] args) {
		//System.out.println(System.currentTimeMillis());1970.1.1 0�ú��� ��������� ��
		//start
		long start = System.currentTimeMillis();
		String str = "a";
		for (int i=0; i<100000; i++) {
			str += "a";
		}
		long end = System.currentTimeMillis();
		System.out.println("��Ʈ��10���� ����ð�:" + (end-start));
		//end
		//start
		start = System.currentTimeMillis();
		StringBuffer strBuf = new StringBuffer("a");
		for (int i=0; i<100000; i++) {
			strBuf.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("��Ʈ������10���� ����ð�:" + (end-start));
		//end
		start = System.currentTimeMillis();
		StringBuffer strbuil = new StringBuffer("a");
		for (int i=0; i<100000; i++) {
			strbuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("��Ʈ������10���� ����ð�:" + (end-start));
		//end
	}

}
