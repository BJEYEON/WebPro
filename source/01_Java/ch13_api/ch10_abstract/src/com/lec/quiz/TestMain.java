package com.lec.quiz;
public class TestMain {
	public static void main(String[] args) {
		Employee[] sawon = {
				new SalaryEmployee("ȫ�浿", 48000000),
				new SalaryEmployee("������", 70000000),
				new SalaryEmployee("�����", 26000000),
				new HourlyEmployee("ȫ�汸", 100,9700),
				new HourlyEmployee("�����", 160,10000)};
		for(Employee temp : sawon){
			System.out.println("~ ~ ~ ���޸��� ~ ~ ~");
			System.out.println("�� �� :"+temp.getName());
			System.out.println("�� �� : "+temp.computePay());
			//System.out.println("�� �� : "+ temp.computeIncentive());
			int tempIncen = temp.computeIncentive();
			if(tempIncen!=0){
				System.out.println("�� �� :"+ tempIncen);
			}//if
		}//for
	}//main
}//class
