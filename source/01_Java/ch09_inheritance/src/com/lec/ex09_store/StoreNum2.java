package com.lec.ex09_store;
//���а��� ����2ȣ��: ��ġ�-8,000  �δ��-8,000  �����-8,000 ���뱹-8,000  �����-����
public class StoreNum2 extends HeadQuarterStore{

	public StoreNum2(String storeName) {
		super(storeName);
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
	
}
