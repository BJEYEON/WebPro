package com.lec.ex3_speaktv;
// 인터페이스: 작업 명세서 역할 (JSP - Spring)
//인터페이스 : 상수(final 변수)와 추상메소드만 (예외: default메소드, static메소드)
public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int SPEAKER_MAX_VOLUME = 100;
	public int TV_MIN_VOLUME = 2;
	public int SPEAKER_MIN_VOLUME = 0;
	public void volumeUp();//볼륨을1씩up
	public void volumeUp(int level);//볼륨을level씩up
	public void volumeDown();// 볼륨을1만큼down
	public void volumeDown(int level);// 볼륨을level만큼down
	public default void setMute(boolean mute) {// 디폴트 메소드
		if (mute) {
			System.out.println("무음");
		}
		else {
			System.out.println("무음해제");
		}
	}
		public static void changeBattery() {
			System.out.println("건전지를 교환합니다");
		}
	
}
