package com.lec.ex02_store;
//���ð� 1ȣ�� �δ��-8000, ���뱹-���Ⱦ�
public class StoreNum1 implements HeadQuarterStore {
	private String storeName; //HeadQuarterStore������� �����°�
	public StoreNum1(String storeName) {
		this.storeName = storeName;
		//super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�-8000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-���Ⱦ�");
	}
	@Override
	public void bibim() {
		System.out.println("�����-9,000��");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gongibab() {
		System.out.println("�����-1,000��");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}

}
