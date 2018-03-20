package co.com.almundo.callcenter;

import co.com.almundo.callcenter.dto.Call;
import co.com.almundo.callcenter.dto.Customer;
import co.com.almundo.callcenter.exception.EmployeeNotAvailableException;

public class CallCenter {
	private static CallCenter instance = null;

	public static CallCenter getInstance() {
		if (instance == null) {
			instance = new CallCenter();
		}
		return instance;
	}
	private CallCenter() {
        super();
    }
	
	public void callIn(Customer client) throws EmployeeNotAvailableException {
		Dispatcher.getInstance().dispatchCall(new Call(client));
	}
}
