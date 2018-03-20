package co.com.almundo.callcenter.dto;

import co.com.almundo.callcenter.enumerator.EmployeeStatus;
import co.com.almundo.callcenter.enumerator.EmployeeType;

public class Employee {
	private String name;
	private EmployeeType type;
	private EmployeeStatus status;	
	
	public Employee() {
		super();
	}
	public Employee(String name, EmployeeType type, EmployeeStatus status) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public EmployeeStatus getStatus() {
		return status;
	}
	public void setStatus(EmployeeStatus status) {
		this.status = status;
	}
}
