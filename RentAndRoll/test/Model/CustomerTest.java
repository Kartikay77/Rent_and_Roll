package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
		
	@Test
    public void testDefaultConstructor() {
        Customer customer = new Customer();
        assertNotNull(customer);
        assertEquals(0, customer.getCustomerId());
        assertNull(customer.getCustomerName());
        assertNull(customer.getPhoneNo());
        assertEquals(0.0f, customer.getBillAmount(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        Customer customer = new Customer(1, "John Doe", "123-456-7890", 100.50f);
        assertNotNull(customer);
        assertEquals(1, customer.getCustomerId());
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123-456-7890", customer.getPhoneNo());
        assertEquals(100.50f, customer.getBillAmount(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Customer customer = new Customer();
        customer.setCustomerId(2);
        customer.setCustomerName("Jane Doe");
        customer.setPhoneNo("987-654-3210");
        customer.setBillAmount(75.25f);

        assertEquals(2, customer.getCustomerId());
        assertEquals("Jane Doe", customer.getCustomerName());
        assertEquals("987-654-3210", customer.getPhoneNo());
        assertEquals(75.25f, customer.getBillAmount(), 0.001);
    }
}


