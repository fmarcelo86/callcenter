package co.com.almundo.callcenter;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import co.com.almundo.callcenter.dto.Customer;
import co.com.almundo.callcenter.exception.EmployeeNotAvailableException;

public class MasDeDiezLlamadasTest {
		
	/* Cuando entra la llamada numero 11 o mas
	 * el sistema retorna el mensaje "No existen empleados libres, por favor espere en la linea"
	 */
	@Test
	public void realizaMasDeDiezLlamadasTest() {
		IntStream.rangeClosed(1, 11).forEach(x -> {
			try {
				CallCenter.getInstance().callIn(new Customer("0000"+x, "Costumer"+x));
			} catch (EmployeeNotAvailableException e) {
				Assert.assertEquals(e.getClass(), EmployeeNotAvailableException.class);
				System.out.println(e.getMessage());
			} 
		});
	}
}
