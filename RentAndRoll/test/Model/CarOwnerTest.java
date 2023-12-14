package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarOwnerTest {

    @Test
    public void testDefaultConstructor() {
        CarOwner carOwner = new CarOwner();
        assertNotNull(carOwner);
        assertEquals(0, carOwner.getOwnerId());
        assertNull(carOwner.getOwnerName());
        assertNull(carOwner.getPhoneNo());
        assertEquals(0.0f, carOwner.getBalanceDue(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        CarOwner carOwner = new CarOwner(1, "John Doe", "123-456-7890", 100.50f);
        assertNotNull(carOwner);
        assertEquals(1, carOwner.getOwnerId());
        assertEquals("John Doe", carOwner.getOwnerName());
        assertEquals("123-456-7890", carOwner.getPhoneNo());
        assertEquals(100.50f, carOwner.getBalanceDue(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        CarOwner carOwner = new CarOwner();
        carOwner.setOwnerId(2);
        carOwner.setOwnerName("Jane Doe");
        carOwner.setPhoneNo("987-654-3210");
        carOwner.setBalanceDue(75.25f);

        assertEquals(2, carOwner.getOwnerId());
        assertEquals("Jane Doe", carOwner.getOwnerName());
        assertEquals("987-654-3210", carOwner.getPhoneNo());
        assertEquals(75.25f, carOwner.getBalanceDue(), 0.001);
    }
}