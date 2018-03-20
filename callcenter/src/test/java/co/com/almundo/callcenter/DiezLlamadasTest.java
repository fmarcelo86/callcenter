package co.com.almundo.callcenter;

import static org.junit.Assert.fail;

import java.util.stream.IntStream;

import org.junit.Test;

import co.com.almundo.callcenter.dto.Customer;
import co.com.almundo.callcenter.exception.EmployeeNotAvailableException;

public class DiezLlamadasTest {
	
	/* La solucion en este caso consistio en tener previamente almacenado los 10 empleados
	 * conforme estos vayan atendiendo llamadas su estado se cambia a ocupado
	 */
	@Test
	public void realizaDiezLlamadasTest() {
		IntStream.rangeClosed(1, 10).forEach(x -> {
			try {
				CallCenter.getInstance().callIn(new Customer("0000"+x, "Costumer"+x));				
			} catch (EmployeeNotAvailableException e) {
				fail();
			}
		});
	}
}
