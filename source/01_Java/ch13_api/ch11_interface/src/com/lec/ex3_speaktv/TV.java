package com.lec.ex3_speaktv;

public class TV implements IVolume {
	private int volumeLevel;
	public TV() {
		volumeLevel = 5;
	}
	@Override
	public void volumeUp() {
		if (volumeLevel < IVolume.TV_MAX_VOLUME) {
		volumeLevel++;
		System.out.println("TV������ 1��ŭ �÷� ���纼����" + volumeLevel);
		}
		else {
			System.out.println("TV������ �ִ�ġ(" + IVolume.TV_MAX_VOLUME + ")���� �ø�������");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < IVolume.TV_MAX_VOLUME) {
			volumeLevel = volumeLevel + level;
			System.out.println("TV������" + level + "��ŭ�÷� ���� ������" + volumeLevel);
		}
		else {
			int tempLevel = TV_MAX_VOLUME-volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������" + tempLevel + "��ŭ �÷��� �ִ�ġ(" + TV_MAX_VOLUME + ")�Դϴ�");
			
		}
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		if (volumeLevel > TV_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("TV������ 1��ŭ ���� ���� ����" + volumeLevel);
		}
		else {
			System.out.println("TV������ �ּ�ġ (" + TV_MIN_VOLUME + ")�Դϴ�");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel-level > TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV������" + level + "��ŭ ���� ���� ������ " + volumeLevel);
		}
		else {
			int tempLevel = volumeLevel - TV_MIN_VOLUME;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV������" + tempLevel + "��ŭ ���� ������ �ּ�ġ(" + TV_MIN_VOLUME + ")");
			
		}//if
	}//volumeDown

}
