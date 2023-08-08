package com.lec.ex2_rect;
// 식별자(클래스명, 패키지명, 변수명): 알파벳, 숫자, _만사용. 알파벳으로 시작
// 클래스: 속성(데이터, 인스턴트변수), 메소드, setter&getter
public class Rect {
	private int width;
	private int height;
	//생성자 함수
	public Rect() {}// 디폴트 생성자 함수(생성자 함수가 없으면 자동생성)
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	public Rect(int side) {
		width = height = side;
	}
	public int area() {//넓이를 return
		return width * height;
	}
	//setter&getter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeigth(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
