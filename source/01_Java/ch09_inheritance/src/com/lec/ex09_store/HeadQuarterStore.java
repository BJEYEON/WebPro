package com.lec.ex09_store;
// º»»ç ÁöÄ§         : ±èÄ¡Âî°³-8,000  ºÎ´ëÂî°³-9,000  ºñºö¹ä-9,000 ¼ø´ë±¹-8,000  °ø±â¹ä-1,000¿ø
// HeadQuarterStore headStore = new HeadQuarterStore ("=º»»ç=")
public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-8000¿ø");
	}
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-9000¿ø");
	}
	public void bibim() {
		System.out.println("ºñºö¹ä-9000¿ø");
		
	}
	public void sunde() {
		System.out.println("¼ø´ë±¹-8000¿ø");
		
	}
	public void gongibab() {
		System.out.println("°ø±â¹ä-1000¿ø");
	}

	public String getStoreName() {
		return storeName;
	}
	
	

}
