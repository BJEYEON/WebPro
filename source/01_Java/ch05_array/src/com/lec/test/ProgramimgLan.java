package com.lec.test;

//{76,45,34,89,100,50,90,93}  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] a_arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int total = 0;
		int maxIdx = 0, max = 0;// �ִ� ���ϱ� ���� ���� (�ִ��� ������)
		int minIdx = 0, min = 999; // �ּҰ��� ���ϱ����� ����
		for (int idx = 0; idx < a_arr.length; idx++) {
			if (a_arr[idx] < min) {
				min = a_arr[idx];
				minIdx = idx;
			} // if
			if (a_arr[idx] > max) {
				max = a_arr[idx];
				maxIdx = idx;
			}
		}
		
		for (int i = 0; i < a_arr.length; i++) {
			total += a_arr[i];
		} // for
		System.out.print("�հ�= " + total + '\t');
		System.out.printf("\t���= %.2f", (double) total / a_arr.length);
		System.out.print("\r�ִ밪��= " + a_arr[maxIdx] + "\t");
		System.out.print("�ּҰ���= " + a_arr[minIdx]);

	}
}
