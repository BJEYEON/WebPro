package com.lec.ex09_store;
// ���� ��ħ         : ��ġ�-8,000  �δ��-9,000  �����-9,000 ���뱹-8,000  �����-1,000��
// HeadQuarterStore headStore = new HeadQuarterStore ("=����=")
public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("��ġ�-8000��");
	}
	public void bude() {
		System.out.println("�δ��-9000��");
	}
	public void bibim() {
		System.out.println("�����-9000��");
		
	}
	public void sunde() {
		System.out.println("���뱹-8000��");
		
	}
	public void gongibab() {
		System.out.println("�����-1000��");
	}

	public String getStoreName() {
		return storeName;
	}
	
	

}
