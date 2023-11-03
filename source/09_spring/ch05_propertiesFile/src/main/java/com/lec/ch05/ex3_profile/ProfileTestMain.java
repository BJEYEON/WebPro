package com.lec.ch05.ex3_profile;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileTestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("DEV(개발중)? RUN(인수후)?");
		String answer = scanner.next(); // "DEV | RUN"
		if(answer.equalsIgnoreCase("DEV")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("RUN")){
			config = "run";
		
		}else {
			System.out.println("제대로된 환경이 입력되지 않았습니다. 확인요망");
			System.exit(0); //정상상태에서 강종
		}
		scanner.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/ex3/CTX_run.xml";
		String loc2 = "classpath:META-INF/ex3/CTX_dev.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip: " + info.getIpNum());
		System.out.println("port: " + info.getPortNum());
	}
}
