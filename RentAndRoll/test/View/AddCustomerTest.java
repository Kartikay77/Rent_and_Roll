package View;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Test;

import Controller.CustomerController;

public class AddCustomerTest {
	@Test
    public void addTest() {
    	AddCustomer ao = new AddCustomer();
        assertNotNull(ao.frame);
        
        CustomerController oc = mock(CustomerController.class);
        when(oc.addCustomer("John", "09876543", 0)).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Add");    
        
        ao.NameTextField.setText("John");
        ao.ContactTextField.setText("09876543");
        ao.AddButton.doClick();
      
        assertNotNull(ao.frame);
    }
	
	@Test
    public void cancelTest() {
    	AddCustomer ao = new AddCustomer();
        assertNotNull(ao.frame);
        
        CustomerController oc = mock(CustomerController.class);
//        when(oc.addOwner("John", "09876543", 0)).thenReturn(49);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Cancel");    
        
        ao.CancelButton.doClick();
      
        assertNotNull(ao.frame);
    }
}
