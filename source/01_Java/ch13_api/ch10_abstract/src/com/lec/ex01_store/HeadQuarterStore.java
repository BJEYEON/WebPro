package com.lec.ex01_store;
// 추상클래스: 추상메소드가 1개이상 있을때
public abstract class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public abstract void kimchi();// 추상메소드: 메소드 명만 선안히고 구현은 없어 구현은 상속받은 클래스가 함(상속받은 클래스에게 오버라이드 강요)
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gongibab();

	public String getStoreName() {
		return storeName;
	}
	
	

}
