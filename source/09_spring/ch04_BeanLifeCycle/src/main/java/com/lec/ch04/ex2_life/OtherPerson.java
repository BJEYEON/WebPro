package com.lec.ch04.ex2_life;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;

@Data
public class OtherPerson {
	private String name;
	private String tel;
	@PostConstruct
	public void initMethod() {
		System.out.println("$OtherPerson형 빈객체 생성하자마자 호출: initMethod()");
	}
	@PreDestroy
	public void preDestory() {
		System.out.println("$ OtherPerson형 빈객체 소멸전 자동호출: peoDestory()");
	}
}
