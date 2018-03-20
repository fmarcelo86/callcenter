package co.com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import co.com.almundo.callcenter.dto.Call;
import co.com.almundo.callcenter.dto.Employee;
import co.com.almundo.callcenter.enumerator.EmployeeStatus;
import co.com.almundo.callcenter.enumerator.EmployeeType;
import co.com.almundo.callcenter.exception.EmployeeNotAvailableException;

public class Dispatcher {
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Call> calls = new ArrayList<Call>();
	private static Dispatcher instance = null;
	private final static String EMPLOYEE_NOT_FOUND = "No existen empleados libres, por favor espere en la linea";

	static {
		getInstance().employees.add(new Employee("Operator1", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator2", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator3", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator4", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator5", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator6", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator7", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Operator8", EmployeeType.OPERATOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Supervisor1", EmployeeType.SUPERVISOR, EmployeeStatus.FREE));
		getInstance().employees.add(new Employee("Director1", EmployeeType.DIRECTOR, EmployeeStatus.FREE));
	}

	public static Dispatcher getInstance() {
		if (instance == null) {
			instance = new Dispatcher();
		}
		return instance;
	}
	private Dispatcher() {
		super();
	}

	public void dispatchCall(final Call call) throws EmployeeNotAvailableException {
		try {
			call.setEmployee(getEmployee());
		} catch (EmployeeNotAvailableException e) {
			calls.add(call);
			throw e;
		}
		call.acceptCall();
		new Thread() {
			public void run() {
				System.out.println("La llamada " + call.getCustomer().getName() + " Será atendida por el " + call.getEmployee().getName());
				callTime();
				call.finalizeCall();
				processCallWait();
			}
			
			private void callTime() {
				try {
					int time = ThreadLocalRandom.current().nextInt(5, 10 + 1)*1000;
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();		
	}
	
	private void processCallWait() {
		if(calls.size() > 0) {
			try {
				dispatchCall(calls.get(0));
			} catch (EmployeeNotAvailableException e) {
				e.printStackTrace();
			}
		}
	}

	private Employee getEmployee() throws EmployeeNotAvailableException {
		List<Employee> employees = getInstance().employees.stream()
				.filter(item -> item.getStatus() == EmployeeStatus.FREE)
				.filter(item -> item.getType() == EmployeeType.OPERATOR)
				.collect(Collectors.toList());
		if(employees.isEmpty()) {
			employees = getInstance().employees.stream()
					.filter(item -> item.getStatus() == EmployeeStatus.FREE)
					.filter(item -> item.getType() == EmployeeType.SUPERVISOR)
					.collect(Collectors.toList());
		}
		if(employees.isEmpty()) {
			employees = getInstance().employees.stream()
					.filter(item -> item.getStatus() == EmployeeStatus.FREE)
					.filter(item -> item.getType() == EmployeeType.DIRECTOR)
					.collect(Collectors.toList());
		}
		if(employees.isEmpty()) {
			throw new EmployeeNotAvailableException(EMPLOYEE_NOT_FOUND);
		}
		return employees.get(0);
	}
	
	
}
