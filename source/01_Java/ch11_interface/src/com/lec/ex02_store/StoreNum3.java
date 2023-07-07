package com.lec.ex02_store;

public class StoreNum3 implements HeadQuarterStore {
	private String storeName; //HeadQuarterStore¿©±ê´ø°Å ³»·Á¿Â°Å
	public StoreNum3(String storeName) {
		this.storeName = storeName;
		//super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-9000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-10000¿ø");
	}
	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä-10000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¾óÅ«¼ø´ë±¹-9000¿ø");
	}
	@Override
	public void gongibab() {
		System.out.println("°ø±â¹ä-1,000¿ø");
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getStoreName() {
		return storeName;
	}
}
