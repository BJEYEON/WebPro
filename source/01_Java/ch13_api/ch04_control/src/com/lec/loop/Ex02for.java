package com.lec.loop;
// 1~10���� �������� 55�Դϴ�
//1+2+3+4+5+6+7+8+9+10 = 55
public class Ex02for {
	public static void main(String[] args) {
		int tot = 0; //�������� ���� ����
		for (int i=1; i<=10; i++) {
			tot += i; //tot = tot + i;
			System.out.print(i);
			if(i!=10) {
				System.out.print("+");
			}
		}
		System.out.println("1����10���� ��������" + tot);
	}

}
