package com.lec.ex1_string;

public class Ex11_speedCheck {
	public static void main(String[] args) {
		//System.out.println(System.currentTimeMillis());1970.1.1 0시부터 현재까지의 초
		//start
		long start = System.currentTimeMillis();
		String str = "a";
		for (int i=0; i<100000; i++) {
			str += "a";
		}
		long end = System.currentTimeMillis();
		System.out.println("스트링10만번 변경시간:" + (end-start));
		//end
		//start
		start = System.currentTimeMillis();
		StringBuffer strBuf = new StringBuffer("a");
		for (int i=0; i<100000; i++) {
			strBuf.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링버퍼10만번 변경시간:" + (end-start));
		//end
		start = System.currentTimeMillis();
		StringBuffer strbuil = new StringBuffer("a");
		for (int i=0; i<100000; i++) {
			strbuil.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("스트링빌더10만번 변경시간:" + (end-start));
		//end
	}

}
