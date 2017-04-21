package pojo;

public class Student {
	
	private int id;
	private String name;
	private String phoneNum;
	public Student(int id, String name, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	

}
