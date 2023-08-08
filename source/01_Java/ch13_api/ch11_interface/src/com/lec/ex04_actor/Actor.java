package com.lec.ex04_actor;

public class Actor implements IPoliceMan, Ichef, IFireFighter {
	private String name;
	public Actor(String name) {
		this.name = name;
	}

	@Override
	public void outFire() {
		System.out.println(name + "�� �ҹ���Դϴ�. ���� ���ϴ�");

	}

	@Override
	public void saveMan() {
		System.out.println(name + "�� �ҹ���Դϴ�. ����� ���մϴ�");
	}

	@Override
	public void makePizza() {
		System.out.println(name + "�� �丮���Դϴ�. ���ڸ� �����ϴ�");
	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name + "�� �丮�� �Դϴ�. ���İ�Ƽ�� ����ϴ�");
	}

	@Override
	public void canCatchCriminal() {
		System.out.println(name + "�� �������Դϴ�. ������ ����ϴ�.");
	}

	@Override
	public void canSearch() {
		System.out.println(name + "�� �������Դϴ�. ������ ã���ϴ�.");
	}

}
