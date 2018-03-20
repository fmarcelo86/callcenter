package co.com.almundo.callcenter;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import co.com.almundo.callcenter.dto.Customer;
import co.com.almundo.callcenter.exception.EmployeeNotAvailableException;

public class SolucionMasDeDiezLlamadasTest {
		
	/* La solucion para cuando entran mas de 10 llamadas consiste en guardar en cola estas llamadas,
	 * de tal forma que cuando un empleado se libere atendera dicha llamada
	 */
	@Test
	public void solucionMasDeDiezLlamadasTest() {
		IntStream.rangeClosed(1, 11).forEach(x -> {
			try {
				CallCenter.getInstance().callIn(new Customer("0000"+x, "Costumer"+x));
				Thread.sleep(700);
			} catch (EmployeeNotAvailableException e) {
				Assert.assertEquals(e.getClass(), EmployeeNotAvailableException.class);
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		});
	}
}
