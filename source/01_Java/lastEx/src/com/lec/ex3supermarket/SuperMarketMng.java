package com.lec.ex3supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarketMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.println("1: ȸ������, 2: ���˻�, 3: ��ǰ����, 4:���������, 5: ��ü���, 6: ȸ��Ż��, �׿� ����");
			fn = scanner.next();
			switch(fn) {
			case "1" :
				System.out.println("������ ȸ�� �ڵ��� ��ȣ?");
				String ctel = scanner.next();
				System.out.println("������ �̸���?");
				String cname = scanner.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS? "���Լ���":"���Խ���");
				break;
			case "2" :
				System.out.println("�˻��� ��ȭ��ȣ ��4�ڸ��� ��ȭ��ȣ ��ü");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println(searchTel + "��ȭ��ȣ�� �˻��� ���� �����ϴ�. ȸ�������ϼ���");
				}else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3" :
				System.out.println("������ �� ���̵��ȣ(���̵� �߸��Էµ� ��� ���� �Ұ�)?");
				int cid = scanner.nextInt();
				if(dao.getCustomer(cid)!= null) {//��������
					System.out.println("���űݾ���?");
					int price = scanner.nextInt();
					result = dao.buy(cid, price);
					if (result == CustomerDao.SUCCESS) {
						System.out.println("���� �����մϴ�." + price + "�� ������ ������ ���� ���� ������ �����ƽ��ϴ�");
						System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
						System.out.println(dao.getCustomer(cid));
					}
				}else {
					System.out.println(cid + "�� ��ȿ�� �� ���̵� �ƴմϴ�. ���źҰ�");
				}
				break;
			case "4" :
				System.out.println("�˻��ϰ��� �ϴ� ������" + dao.getLevelNames() + "��?");
				String levelName = scanner.next();
				customers =  dao.levelNameGetCustomers(levelName);
				if(customers.isEmpty()) {
					System.out.println("���� �˻����� �ʾҽ��ϴ�.");
				}else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
				for (CustomerDto customer : customers) {
					System.out.println(customer);
				}
				System.out.println("��" + customers.size() + "��");
				}
				break;
			case "5" :
				customers = dao.getCustomers();
				if(customers.isEmpty()) {
					System.out.println("���� �˻����� �ʾҽ��ϴ�.");
				}else {
					System.out.println("���̵�\t�ڵ�����ȣ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
				for (CustomerDto customer : customers) {
					System.out.println(customer);
				}
				System.out.println("��" + customers.size() + "��");
				}
				break;
			case "6" :
				System.out.println("Ż���� ��ȭ��ȣ��?");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS? "��������": "��������");
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6"));
	}

}
