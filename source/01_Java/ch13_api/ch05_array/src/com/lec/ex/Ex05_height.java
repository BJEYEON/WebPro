package com.lec.ex;

import java.util.Scanner;

//�迭�� �̿��Ͽ� ģ����"����","ö��","�浿","����","����"�� Ű�� �Է¹ް�, ���Ű�� ���
//���� ū ģ���� ���� ���� ģ���� ���(ex�浿180)
public class Ex05_height {
	public static void main(String[] args) {
		String[] name = {"����","ö��","�浿","����","����"};
		int[] height = new int[name.length];
		int totalHeight = 0; // Ű����
		Scanner scanner = new Scanner(System.in);
		//Ű�Է¹ޱ�
		for (int idx=0; idx<name.length; idx++) {
			System.out.print(name[idx] + "�� Ű��?");
			height[idx] = scanner.nextInt();
			totalHeight += height[idx]; //Ű������
		}
		for(int idx=0; idx<name.length; idx++) {
			System.out.println(name[idx] + ":" + height[idx]);
		}
		System.out.printf("���Ű: %.2f\n", (double)totalHeight/name.length);
		scanner.close();
		//�����,�ִܽ�
		int maxIdx = 0, max = 0;//������� ���ϱ� ���� ���� (�ִ��� ������)
		int minIdx = 0, min = 999; //�ִܽ��� ���ϱ����� ����
		for (int idx=0; idx<name.length; idx++) {
			if (height[idx]<min) {
				min = height[idx];
				minIdx = idx;
			}//if
			if (height[idx]>max) {
				max = height[idx];
				maxIdx = idx;
			}
		}//for
		System.out.println("�����: " + name[maxIdx] + "-" + height[maxIdx]);
		System.out.println("�ִܽ�: " + name[minIdx] + "-" + height[minIdx]);
	}//main

}
