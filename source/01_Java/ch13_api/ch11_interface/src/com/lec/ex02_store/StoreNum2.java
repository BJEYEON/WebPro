package com.lec.ex02_store;
//���а��� ����2ȣ��: ��ġ�-8,000  �δ��-8,000  �����-8,000 ���뱹-8,000  �����-����
public class StoreNum2 implements HeadQuarterStore{
	private String storeName; //HeadQuarterStore������� �����°�
	public StoreNum2(String storeName) {
		this.storeName = storeName;
		//super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����-8000��");
	}
	@Override
	public void gongibab() {
		System.out.println("����");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�-8,000��");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-8,000��");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
	
}
