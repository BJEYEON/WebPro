package strategy3quiz;



public class Student extends Person {
		private String ban;
		public Student(String id, String name, String ban) {
			super(id, name);
			this.ban = ban;
		setGet(new GetStudentPay());
		setJob(new JobStudy());
		
	}
		@Override
		public void print() {
			super.print();
			System.out.println("\t[¹Ý]"+ban);
		}

}
