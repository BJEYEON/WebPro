package strategy3quiz;



public class Person {
	private JobImpl job;
	private GetImpl get;
	private String name;
	private String id;
	public Person() {} //디폴트 생성자
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public void isJob() {
		job.job();
	}
	public void isGet() {
		get.get();
	}
	public void setJob(JobImpl job) {
		this.job = job;
	}
	public void setGet(GetImpl get) {
		this.get = get;
	}
	public void print() {
		System.out.print("ID(" + id  + "), 이름(" + name + ")");
	}
	
	
	
}
