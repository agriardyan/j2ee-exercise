package pojo;

import java.util.List;

public class Bundle {
	
	private List<Student> data;
	private String message;
	
	public Bundle(List<Student> data, String message) {
		super();
		this.data = data;
		this.message = message;
	}
	public List<Student> getData() {
		return data;
	}
	public void setData(List<Student> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
