package View;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Test;

import Controller.BookingController;

public class AddBookingTest {
	@Test
    public void addTest() {
    	AddBooking ao = new AddBooking();
        assertNotNull(ao.getRootPane());
        
        BookingController oc = mock(BookingController.class);
//        when(oc.addBooking("2023-12-25 09:00:00", "2023-12-30 09:00:00", "9", "7")).thenReturn(30);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Book");    
        
        ao.RentTimeTextField.setText("2023-12-25 09:00:00");
        ao.ReturnTimeTextField.setText("2023-12-30 09:00:00");
        ao.CarIDTextField.setText("9");
        ao.CustomerIDTextField.setText("7");
        
        ao.BookButton.doClick();
      
        assertNotNull(ao.getRootPane());
    }
	
	@Test
    public void cancelTest() {
    	AddBooking ao = new AddBooking();
        assertNotNull(ao.getRootPane());
        
        BookingController oc = mock(BookingController.class);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Cancel");    
        
        ao.CancelButton.doClick();
      
        assertNotNull(ao.getRootPane());
    }

}
