package com.lec.ex3_speaktv;
// �������̽�: �۾� ���� ���� (JSP - Spring)
//�������̽� : ���(final ����)�� �߻�޼ҵ常 (����: default�޼ҵ�, static�޼ҵ�)
public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int SPEAKER_MAX_VOLUME = 100;
	public int TV_MIN_VOLUME = 2;
	public int SPEAKER_MIN_VOLUME = 0;
	public void volumeUp();//������1��up
	public void volumeUp(int level);//������level��up
	public void volumeDown();// ������1��ŭdown
	public void volumeDown(int level);// ������level��ŭdown
	public default void setMute(boolean mute) {// ����Ʈ �޼ҵ�
		if (mute) {
			System.out.println("����");
		}
		else {
			System.out.println("��������");
		}
	}
		public static void changeBattery() {
			System.out.println("�������� ��ȯ�մϴ�");
		}
	
}
