package com.lec.ex02_store;

public class StoreNum3 implements HeadQuarterStore {
	private String storeName; //HeadQuarterStore������� �����°�
	public StoreNum3(String storeName) {
		this.storeName = storeName;
		//super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ�-9000��");
	}
	@Override
	public void bude() {
		System.out.println("�δ��-10000��");
	}
	@Override
	public void bibim() {
		System.out.println("�����-10000��");
	}
	@Override
	public void sunde() {
		System.out.println("��ū���뱹-9000��");
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
