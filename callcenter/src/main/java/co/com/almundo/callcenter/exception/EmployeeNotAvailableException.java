package co.com.almundo.callcenter.exception;

public class EmployeeNotAvailableException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotAvailableException(String message) {
		super(message);
	}
}
