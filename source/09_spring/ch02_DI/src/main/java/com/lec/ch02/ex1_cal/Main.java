package com.lec.ch02.ex1_cal;
//Main은 myCalculation을 의존, myCalcuation은calulator를의존

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String resourseLoaction = "classpath:applicationCTX.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourseLoaction);
		MyCalculation myCalculation = ctx.getBean("myCal", MyCalculation.class);
		myCalculation.add();
		myCalculation.sub();
		myCalculation.mul();
		myCalculation.div();
		ctx.close();
	}
	
}
