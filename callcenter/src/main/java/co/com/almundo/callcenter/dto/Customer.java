package co.com.almundo.callcenter.dto;

public class Customer {
	private String phone;
	private String name;
	
	public Customer(String phone, String name) {
		super();
		this.phone = phone;
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
