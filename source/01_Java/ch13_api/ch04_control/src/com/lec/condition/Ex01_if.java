package com.lec.condition;
//���� �Ҵ� �� ������ ���� ����� ���
public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if (score >= 90) {
			System.out.println("�Ϻ��մϴ�");
		}
		else if (score>=70){
			System.out.println("�� �Ϻ� �� �ϳ�");
		}
		else if(score>=60) {
			System.out.println("���� �й��Ͻô���");
		}
		else {
			System.out.println("����� �Դϴ�");
		}
		System.out.println("done");
	}

}
