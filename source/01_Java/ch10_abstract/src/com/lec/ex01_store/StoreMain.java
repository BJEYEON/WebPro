package com.lec.ex01_store;

public class StoreMain {
	public static void main(String[] args) {
//		HeadQuarterStore headStore = new HeadQuarterStore("=본사=");
//		StoreNum1 store1 = new StoreNum1("=주택가 1호점");
//		StoreNum2 store2 = new StoreNum2("=대학가 2호점");
//		StoreNum3 store3 = new StoreNum3("=증권가 3호점");
		HeadQuarterStore[] stores = { //new HeadQuarterStore("=본사="),
									  new StoreNum1("=주택가 1호점"),
									  new StoreNum2("=대학가 2호점"),
									  new StoreNum3("=증권가 3호점") };// 배열
		for (HeadQuarterStore store : stores) {
			System.out.println(store.getStoreName());
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongibab();
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■");
		for (int i=0; i<stores.length; i++) {
			System.out.println(stores[i].getStoreName());
			stores[i].kimchi();
			stores[i].bude();
			stores[i].bibim();
			stores[i].sunde();
			stores[i].gongibab();
		}
	}// main

}
