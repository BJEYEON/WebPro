package com.lec.loopQuiz;
//���ϴ� ������
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<10 ; i++) {
			System.out.println("���ϴ� ������ ���� �Է��ϼ���.:");
			num = scanner.nextInt(); // 1~9
			if (num > 9 || num < 1) {
				System.out.println("�߸��Է��߽��ϴ�");
			}
				else if (num<=1 || num<=9) { 
					break;
				}
				
			}//for
	for(int j = 1;j<10;j++){
			System.out.printf("%d*%d=%d\t", num, j, num*j);
		}
}
// main
}