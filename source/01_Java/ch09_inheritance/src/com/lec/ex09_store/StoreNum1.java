package com.lec.ex09_store;
//���ð� 1ȣ�� �δ��-8000, ���뱹-���Ⱦ�
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("�δ��-8000");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹-���Ⱦ�");
	}

}
