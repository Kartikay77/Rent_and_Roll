package View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import org.junit.Test;

public class LoginTest {
	@Test
    public void testLogin() {
        Login login = new Login();
        assertNotNull(login.getMainPanel());
    }
	
	@Test
    public void testLoginAction() {
        Login login = new Login();
        assertNotNull(login.getMainPanel());
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Logout");    
        login.UN_TextField.setText("admin");
        login.Password_Field.setText("123");
        login.Login_Button.doClick();
        assertNotNull(login.getMainPanel());
    }
}
