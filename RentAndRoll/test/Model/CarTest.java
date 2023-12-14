package Model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testSetAndGetCarId() {
        Car car = new Car();
        car.setCarId(123);
        assertEquals(123, car.carId());
    }

    @Test
    public void testSetAndGetMakerName() {
        Car car = new Car();
        car.setMakerName("Toyota");
        assertEquals("Toyota", car.getMakerName());
    }

    @Test
    public void testSetAndGetCarName() {
        Car car = new Car();
        car.setCarName("Camry");
        assertEquals("Camry", car.getCarName());
    }

    @Test
    public void testSetAndGetColor() {
        Car car = new Car();
        car.setColor("Red");
        assertEquals("Red", car.getColor());
    }

    @Test
    public void testSetAndGetCarType() {
        Car car = new Car();
        car.setCarType("Sedan");
        assertEquals("Sedan", car.getCarType());
    }

    @Test
    public void testSetAndGetCarCondition() {
        Car car = new Car();
        car.setCarCondition("Excellent");
        assertEquals("Excellent", car.getCarCondition());
    }

    @Test
    public void testSetAndGetCarRegNo() {
        Car car = new Car();
        car.setCarRegNo("ABC123");
        assertEquals("ABC123", car.getCarRegNo());
    }

    @Test
    public void testSetAndGetCarModel() {
        Car car = new Car();
        car.setCarModel("Model X");
        assertEquals("Model X", car.getCarModel());
    }

    @Test
    public void testSetAndGetSeatingCapacity() {
        Car car = new Car();
        car.setSeatingCapacity(5);
        assertEquals(5, car.getSeatingCapacity());
    }

    @Test
    public void testSetAndGetRentPerHour() {
        Car car = new Car();
        car.setRentPerHour(50.0f);
        assertEquals(50.0f, car.getRentPerHour(), 0.001);
    }

    @Test
    public void testSetAndGetCarOwnerId() {
        Car car = new Car();
        car.setcarOwnerID(456);
        assertEquals(456, car.getCarOwnerId());
    }

    @Test
    public void testSetAndGetCarOwnerName() {
        Car car = new Car();
        car.setCarOwnerName("John Doe");
        assertEquals("John Doe", car.getCarOwnerName());
    }
}
