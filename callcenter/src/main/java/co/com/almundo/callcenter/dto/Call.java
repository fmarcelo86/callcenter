package co.com.almundo.callcenter.dto;

import co.com.almundo.callcenter.ICall;
import co.com.almundo.callcenter.enumerator.EmployeeStatus;

public class Call implements ICall {
	private Customer customer;
	private Employee employee;
	
	public Call(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void acceptCall() {
		employee.setStatus(EmployeeStatus.BUSY);
	}

	@Override
	public void finalizeCall() {
		employee.setStatus(EmployeeStatus.FREE);
		employee = null;
	}
}
