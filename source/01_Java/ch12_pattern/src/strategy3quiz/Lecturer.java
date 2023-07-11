package strategy3quiz;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setGet(new GetSalary());
		setJob(new JobLec());
		
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[¹Ý]" + subject);
	}

}
