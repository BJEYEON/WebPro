package com.lec.ex4_newException;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book[] books = {new Book("890-��01", "java", "������"),
						new Book("890-��02", "oracle", "���浿"),
						new Book("890-��03", "mysql", "���̵�"),
						new Book("890-��04", "jdbc", "������"),
						new Book("890-��05", "html", "�̿�ġ")};
		Scanner scanner = new Scanner(System.in);
		int fn; //��ɹ�ȣ(1:����, 2:�ݳ�, 3:ålist���, 0 ����)
		int idx; //�����ϰų� �ݳ��� �� ��ȸ�� å�� index
		String bTitle, borrower, checkOutDate;//����ڿ��� �Է¹��� å�̸�, ������, ������
		do {
			System.out.println("1:����| 2:�ݳ� | 3:ålist | 0:����");
			fn = scanner.nextInt();// white=space�ձ��� �Էµ� ������ ����
			switch(fn) {
			case 1: 
				System.out.println("������ å�̸���:");
				//���� 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4. ������ 5.������ 6.chexkOut������,�����ϸ޼ҵ�ȣ��
				// 1.å�̸��Է�
				bTitle = scanner.next(); //white-space�ձ��� �Էµ� ��Ʈ���� ����
				//2. å��ȸ
				for (idx=0; idx<books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						
					}
				}
			if (idx == books.length) {
				System.out.println("���� �������� �ʴ� �����Դϴ�");
				break;//for��������
			}
			else {//book[idx]������ ����
				//3.å����Ȯ��
				if (books[idx].getState() == Book.STATE_BORROWED) {
					System.out.println("�������� �����Դϴ�");
				}
				else {
					
				}
			}
			
			//4.�������Է�
			System.out.println("������?");
			borrower = scanner.next();
			//5.�������Է�
			System.out.println("�������� (07-07)?");
			checkOutDate = scanner.next();
			//6.checkOut�޼ҵ�ȣ��
			books[idx].checkOut(borrower);
			case 2: //�ݳ�: 1.å�̸��Է� 2.å��ȸ 3.checkIn()�޼ҵ� ȣ��
				// 1. å�̸��Է�
				System.out.println("�ݳ��� å�̸���?");
				bTitle = scanner.next();
				//2.å��ȸ
				for (idx=0; idx<books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("�ش絵���� �� ������ å�� �ƴմϴ�");
				}
				else {
					//3. checkIn()�޼ҵ� ȣ��
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				//System.out.println("�ݳ�����");break;
			case 3:
				for(Book book : books) {
					//book.printState();
					System.out.println(book);
				}
			}
		}while(fn!=0);
 	}

}
