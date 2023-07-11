package strategy3quiz;

public class Staff extends Person {
	private String part;
			public Staff(String id, String name, String part) {
			super(id, name);
			this.part = part;
		setGet(new GetSalary());
		setJob(new JobMng());
		
	}
		@Override
		public void print() {
			super.print();
			System.out.println("\t[ºÎ¼­]"+part);
		}

}
