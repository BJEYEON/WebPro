package com.lec.ex02_store;
// 추상클래스: 추상메소드가 1개이상 있을때
public interface HeadQuarterStore {
	/*
	private String storeName;
	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	*/
	public /*abstract*/ void kimchi();// 추상메소드: 메소드 명만 선안히고 구현은 없어 구현은 상속받은 클래스가 함(상속받은 클래스에게 오버라이드 강요)
	public  void bude();
	public  void bibim();
	public  void sunde();
	public  void gongibab();
	public String getStoreName();
	
		//return storeName;
	
	
	

}
