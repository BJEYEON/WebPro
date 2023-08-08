package com.lec.ex3supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("1. ȸ������ �׽�Ʈ");
		String ctel = "010-4444-5555";
		String cname = "���浿";
		result = dao.insertCustomer(ctel, cname);
		System.out.println(result == CustomerDao.SUCCESS? cname + "�� ȸ������ ����.����Ʈ1000���ο�": cname + "�� ȸ������ ����");
		System.out.println("2. ��ȭ��ȣ �˻� �׽�Ʈ");
		String searchTel = "9999";
		customers = dao.ctelGetCustomers(searchTel);
		if (customers.isEmpty()) {
			System.out.println(searchTel + "��ȭ��ȣ�� �˻��� ���� �����ϴ�");
		}else {
			System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("3. ��ǰ����");
		int cid=4
				;
		if (dao.getCustomer(cid)!= null) {
			int price = 500000;
			result = dao.buy(cid, price);// cid���� price�� ��ǰ����
			if (result == CustomerDao.SUCCESS) { //��ǰ���� ����
				System.out.println("��ǰ���� �����մϴ�. ������ ������ �Ʒ��� ���� ������Ʈ �Ǿ����ϴ�");
				System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
				System.out.println(dao.getCustomer(cid));
				
			}
			
		}else {
			System.out.println(cid + "�� ��ȿ���� �ʴ� id�� ���źҰ�");
		}
		System.out.println("5.��ü ���");
		customers = dao.getCustomers();
		if (customers.size() == 0) {
			System.out.println("�ش緹���� �����ϴ�");
		}
		else {
		System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
		for (CustomerDto customer : customers) {
			System.out.println(customer);
		}
		System.out.println("6. ȸ��Ż��");
		result = dao.deleteCustomer("010-9999-9999");
		System.out.println(result == CustomerDao.SUCCESS? "��������":"��ȿ�� ��ȣ�� �ƴմϴ�");
	}
	}
}
