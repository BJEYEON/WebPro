package com.lec.ex02_store;
//주택가 1호점 부대찌개-8000, 순대국-안팔아
public class StoreNum1 implements HeadQuarterStore {
	private String storeName; //HeadQuarterStore여깃던거 내려온거
	public StoreNum1(String storeName) {
		this.storeName = storeName;
		//super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개-8000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개-8000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국-안팔아");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥-9,000월");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥-1,000원");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}

}
