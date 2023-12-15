package View;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Test;

import Controller.CarController;

public class AddCarTest {
	@Test
    public void addTest() {
    	AddCar ao = new AddCar();
        assertNotNull(ao.getRootPane());
        
        CarController oc = mock(CarController.class);
//        when(oc.addCar("a", "b", "9")).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Add");    
        
        ao.MakerTextField.setText("a");
        ao.NameTextField.setText("b");
        ao.RegNoTextField.setText("9");
        ao.OwnerIDTextField.setText("7");
        ao.RentPerHourTextField.setText("7");
        ao.AddButton.doClick();
      
        assertNotNull(ao.getRootPane());
    }
	
	@Test
    public void cancelTest() {
    	AddCar ao = new AddCar();
        assertNotNull(ao.getRootPane());
        
        CarController oc = mock(CarController.class);
//        when(oc.addCar("John", "09876543", 0)).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Cancel");    
        
        ao.CancelButton.doClick();
      
        assertNotNull(ao.getRootPane());
    }
}
