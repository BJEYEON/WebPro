package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i =20; //int����i�� ����, �ʱ�ȭ
		//1. �迭 ������ ����� �ʱ�ȭ
		int[] iArr = {10,20,30,40,50};
		iArr[2] = 300;
		for (int idx = 0; idx<iArr.length; idx++) {
			System.out.println(idx + "���� ���� ����" + iArr[idx]);
		}
		//2.�迭 ���� ����� �迭 �޸� Ȯ��
		int[] iArr2 = new int[5]; //array 5ĭ�� Ȯ���ض�
		iArr2[2] = 99;
		for (int idx=0; idx<iArr2.length; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		//3.�迭���� ����
		int[] iArr3;
		iArr3 = new int[3];
		iArr3[0] = 99;
		// �Ϲ�for��
		for (int idx=0; idx<iArr3.length; idx++) {
			System.out.println(idx + "��°: " + iArr3[idx]);
		}
	}//main

}
