package com.lec.loopQuiz;
//1����10���� Ȧ�� ������
public class Quiz4 {
	public static void main(String[] args) {
		int tot = 0; // �������� ���� ����
		for (int i = 1; i <= 10; i++) {
			if ((i % 2) != 0) {
				tot += i; // tot = tot + i;
			}
		}
		System.out.println("1����10����Ȧ�� ��������" + tot);
	}

}
