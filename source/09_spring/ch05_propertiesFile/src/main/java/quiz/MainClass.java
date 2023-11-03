package quiz;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch05.ex3_profile.ServerInfo;

public class MainClass {
	public static void main(String[] args) {
		String config = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("dev? run?");
		String answer = scanner.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로된 환경이 입력되지 않았습니다");
			System.exit(0);
		}
		scanner.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		String loc1 = "classpath:META-INF/quiz/run.xml";
		String loc2 = "classpath:META-INF/quiz/dev.xml";
		ctx.load(loc1, loc2);
		ctx.refresh();
		EnvInfo info = ctx.getBean("envInfo", EnvInfo.class);
		System.out.println("ipNum: " + info.getIpNum());
		System.out.println("portNum: " + info.getPortNum());
		System.out.println("userId: " + info.getUserId());
		System.out.println("userPw: " + info.getUserPw());
	}
	
}
