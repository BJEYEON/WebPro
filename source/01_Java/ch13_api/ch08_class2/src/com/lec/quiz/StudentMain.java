package com.lec.quiz;

public class StudentMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("마동석", 99, 99, 99);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"번호 이름", "국어", "영어", "수학", "총점", "평균"};
		//int totKor = 0, totEng = 0, totMat = 0;
		int[] total = new int[5]; // 0번 idx: 국어누적, 1번idx영어누적...4번idx평균누적
		line();//■■■■■■■■■
		System.out.println("\t\t\t성 적 표");
		line('-');
		for (String t: title) {
			System.out.print(t + '\t');
		}
		System.out.println();
		line('-');
		for (int idx=0; idx<students.length; idx++) {
			System.out.println(students[idx].infoString());
			total[0] += students[idx].getKor();
			total[1] += students[idx].getEng();
			total[2] += students[idx].getMat();
			total[3] += students[idx].getTot();
			//total[3] += students[idx].getAvg();
			total[4] += total[4] + (int)students[idx].getAvg();	
		}
		line('-');
		System.out.print("총점");
		for (int tot : total) {
			System.out.print("\t" + tot);
		}
		System.out.print("\n평균");
		for (int tot : total) {
			System.out.printf("\t%.1f" , (double)tot/students.length);
		}
		System.out.println();
		line();//■■■■■■■■■■■■■■
	}
	private static void line(char c) {
		//System.out.print('\t');
		for (int i=0; i<50; i++) {
			System.out.print(c);
		}
	
		System.out.println();
	}
	private static void line() {//진하라인
		for (int i=0; i<65; i++) {
			System.out.print('■');
		}
		System.out.println();
		
		
	}

}
