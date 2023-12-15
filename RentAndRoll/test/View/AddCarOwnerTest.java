package View;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Controller.CarOwnerController;

public class AddCarOwnerTest {
	@Test
    public void addTest() {
    	AddCarOwner ao = new AddCarOwner();
        assertNotNull(ao.frame);
        
        CarOwnerController oc = mock(CarOwnerController.class);
        when(oc.addOwner("John", "09876543", 0)).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Add");    
        
        ao.NameTextField.setText("John");
        ao.ContactTextField.setText("09876543");
        ao.AddButton.doClick();
      
        assertNotNull(ao.frame);
    }
	
	@Test
    public void cancelTest() {
    	AddCarOwner ao = new AddCarOwner();
        assertNotNull(ao.frame);
        
        CarOwnerController oc = mock(CarOwnerController.class);
        when(oc.addOwner("John", "09876543", 0)).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Cancel");    
        
        ao.CancelButton.doClick();
      
        assertNotNull(ao.frame);
    }
}
