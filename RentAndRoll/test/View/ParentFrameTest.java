package View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import View.ParentFrame.Parent_JFrame_ActionListner;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;


public class ParentFrameTest {

    @Test
    public void testParentFrame() {
        ParentFrame parentFrame = new ParentFrame();
        assertNotNull(parentFrame.getMainFrame());
        assertNotNull(parentFrame.getMainFrame().getWindowListeners());
        assertEquals(1, parentFrame.getMainFrame().getWindowListeners().length);
    }
    
    @Test
    public void testExitAction() {
        ParentFrame parentFrame = new ParentFrame();
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Exit");    
        JOptionPane mockOption = mock(JOptionPane.class);
//        when(mockOption.showConfirmDialog(null, "You are about to terminate the program.\n"
//                + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null)).thenReturn(1); 
        parentFrame.Exit.doClick();
        assertNotNull(parentFrame.getMainFrame());
//        assertDoesNotThrow(mockOption);
    }
    
    @Test
    public void testLogoutAction() {
        ParentFrame parentFrame = new ParentFrame();
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Logout");    
        assertNotNull(parentFrame.getMainFrame());
        parentFrame.Logout.doClick();
        assertNotNull(parentFrame.getMainFrame());
    }
}
