package View;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import org.junit.Test;

import Controller.CustomerController;
import Model.Customer;
import View.AddCar;
import View.CustomerDashboard;

public class CustomerDashboardTest {
	@Test
    public void testCustomerDashboard() {
        CustomerDashboard customerDashboard = new CustomerDashboard();
            
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        
        assertNotNull(customerDashboard.getMainPanel());
        
    }
    
    @Test
    public void testRemove() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Remove");   
        
        JTable CustomerTable = mock(JTable.class);
        when(CustomerTable.getSelectedRow()).thenReturn(3);
        when(CustomerTable.getRowCount()).thenReturn(10);
        when(CustomerTable.getValueAt(1,0)).thenReturn(5);
        
        customerDashboard.RemoveButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
    }  
    
    @Test
    public void testClear() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Clear Bill");  
        JTable CustomerTable = mock(JTable.class);
        when(CustomerTable.getSelectedRow()).thenReturn(1);
        when(CustomerTable.getValueAt(1,0)).thenReturn(5);
        when(CustomerTable.getRowCount()).thenReturn(10);
        
        customerDashboard.ClearBillButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
    }
    
    @Test
    public void testSearchId() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        Customer co = new Customer();
        when(oc.getCustomerById(3)).thenReturn(co);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Search ID");    
        
        customerDashboard.SearchIdTextField.setText("3");
        customerDashboard.SearchIdButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
    }
    
    @Test
    public void testSearchName() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        when(oc.getCustomersByName("john")).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Search Name");  
        
        customerDashboard.SearchNameTextField.setText("john");
        customerDashboard.SearchNameButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
    }
    
    @Test
    public void testAdd() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Add");
        
        AddCustomer addCustomer = mock(AddCustomer.class);
        
        customerDashboard.AddButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
        
    }
    
    @Test
    public void testBackAction() {
    	CustomerDashboard customerDashboard = new CustomerDashboard();
        assertNotNull(customerDashboard.getMainPanel());
        
        CustomerController oc = mock(CustomerController.class);
        List<Customer> owlist = new ArrayList();
        when(oc.getAllCustomers()).thenReturn(owlist);
        
        ActionEvent ae = mock(ActionEvent.class);
        when(ae.getActionCommand()).thenReturn("Back");    
        
        customerDashboard.BackButton.doClick();
        assertNotNull(customerDashboard.getMainPanel());
    }
}
