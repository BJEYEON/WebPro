package com.lec.ex01_store;
//대학가에 매장2호점: 김치찌개-8,000  부대찌개-8,000  비빔밥-8,000 순대국-8,000  공기밥-무료
public class StoreNum2 extends HeadQuarterStore{

	public StoreNum2(String storeName) {
		super(storeName);
	}
	@Override
	public void bude() {
		System.out.println("부대찌개-8000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥-8000원");
	}
	@Override
	public void gongibab() {
		System.out.println("무료");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개-8,000월");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sunde() {
		System.out.println("순대국-8,000원");
		// TODO Auto-generated method stub
		
	}
	
}
