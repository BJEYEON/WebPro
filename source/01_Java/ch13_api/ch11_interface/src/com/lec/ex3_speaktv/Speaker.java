package com.lec.ex3_speaktv;

public class Speaker implements IVolume {
	private int volumeLevel;
	public Speaker() {
		volumeLevel = 5;
	}
	@Override
	public void volumeUp() {
		if (volumeLevel < IVolume.SPEAKER_MAX_VOLUME) {
		volumeLevel++;
		System.out.println("SPEAKER������ 1��ŭ �÷� ���纼����" + volumeLevel);
		}
		else {
			System.out.println("SPEAKER������ �ִ�ġ(" + IVolume.SPEAKER_MAX_VOLUME + ")���� �ø�������");
		}
	}

	@Override
	public void volumeUp(int level) {
		if (volumeLevel + level < IVolume.SPEAKER_MAX_VOLUME) {
			volumeLevel = volumeLevel + level;
			System.out.println("SPEAKER������" + level + "��ŭ�÷� ���� ������" + volumeLevel);
		}
		else {
			int tempLevel = SPEAKER_MAX_VOLUME-volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER ������" + tempLevel + "��ŭ �÷��� �ִ�ġ(" + SPEAKER_MAX_VOLUME + ")�Դϴ�");
			
		}
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		if (volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel--;
			System.out.println("SPEAKER������ 1��ŭ ���� ���� ����" + volumeLevel);
		}
		else {
			System.out.println("SPEAKER������ �ּ�ġ (" + SPEAKER_MIN_VOLUME + ")�Դϴ�");
		}
	}

	@Override
	public void volumeDown(int level) {
		if (volumeLevel-level > SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("SPEAKER������" + level + "��ŭ ���� ���� ������ " + volumeLevel);
		}
		else {
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER������" + tempLevel + "��ŭ ���� ������ �ּ�ġ(" + SPEAKER_MIN_VOLUME + ")");
			
		}//if
	}//volumeDown

}
