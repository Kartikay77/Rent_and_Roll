package View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.junit.Test;

public class MainMenuTest {
	@Test
    public void testMainMenu() {
        MainMenu mainMenu = new MainMenu();
        assertNotNull(mainMenu.getMainPanel());
    }
    
    @Test
    public void testCarsAction() {
    	MainMenu mainMenu = new MainMenu();
        assertNotNull(mainMenu.getMainPanel());
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Cars");    
        
        CarDashboard cd = mock(CarDashboard.class);
        mainMenu.CarsButton.doClick();
        assertNotNull(mainMenu.getMainPanel());
    }
    
    @Test
    public void testCustAction() {
    	MainMenu mainMenu = new MainMenu();
        assertNotNull(mainMenu.getMainPanel());
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Customer");    
        
        CustomerDashboard cd = mock(CustomerDashboard.class);
        mainMenu.CustomerButton.doClick();
        assertNotNull(mainMenu.getMainPanel());
    }
    
    @Test
    public void testOwnerAction() {
    	MainMenu mainMenu = new MainMenu();
        assertNotNull(mainMenu.getMainPanel());
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Owner");    
        
        mainMenu.OwnerButton.doClick();
        assertNotNull(mainMenu.getMainPanel());
    }
    
    @Test
    public void testBookingAction() {
    	MainMenu mainMenu = new MainMenu();
        assertNotNull(mainMenu.getMainPanel());
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Booking");    
        
        mainMenu.BookingButton.doClick();
        assertNotNull(mainMenu.getMainPanel());
    }
    
}
