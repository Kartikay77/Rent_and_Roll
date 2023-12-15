package View;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.junit.Test;

import Controller.CarOwnerController;
import Model.CarOwner;

public class OwnerDashboardTest {
	
	@Test
    public void testOwnerDashboard() {
        OwnerDashboard ownerDashboard = new OwnerDashboard();
            
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        
        assertNotNull(ownerDashboard.getMainPanel());
        
    }
    
    @Test
    public void testCarsAction() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Remove");   
        
        JTable OwnerTable = mock(JTable.class);
        when(OwnerTable.getSelectedRow()).thenReturn(3);
        when(OwnerTable.getRowCount()).thenReturn(10);
        when(OwnerTable.getValueAt(1,0)).thenReturn(5);
        
        ownerDashboard.RemoveButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
    }  
    
    @Test
    public void testCustAction() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Clear Balance");  
        JTable OwnerTable = mock(JTable.class);
        when(OwnerTable.getSelectedRow()).thenReturn(1);
        when(OwnerTable.getValueAt(1,0)).thenReturn(5);
        when(OwnerTable.getRowCount()).thenReturn(10);
        
        ownerDashboard.ClearBalanceButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
    }
    
    @Test
    public void test1() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        CarOwner co = new CarOwner();
        when(oc.getOwnerById(3)).thenReturn(co);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Search ID");    
        
        ownerDashboard.SearchIdTextField.setText("3");
        ownerDashboard.SearchIdButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
    }
    
    @Test
    public void test2() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        when(oc.getOwnersByName("john")).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Search Name");  
        
        ownerDashboard.SearchNameTextField.setText("john");
        ownerDashboard.SearchNameButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
    }
    
    @Test
    public void testBookingAction() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Add");
        
        AddCar addCar = mock(AddCar.class);
        
        ownerDashboard.AddButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
        
    }
    
    @Test
    public void testBackAction() {
    	OwnerDashboard ownerDashboard = new OwnerDashboard();
        assertNotNull(ownerDashboard.getMainPanel());
        
        CarOwnerController oc = mock(CarOwnerController.class);
        List<CarOwner> owlist = new ArrayList();
        when(oc.getAllOwners()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Back");    
        
        ownerDashboard.BackButton.doClick();
        assertNotNull(ownerDashboard.getMainPanel());
    }
}
