/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.Serializable;

public class Customer implements Serializable{
    private int customerId;
    private String  customerName;
    private String contactNo;
    private float bill;

    public Customer(int customerId, String customerName, String contactNo, float bill) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNo = contactNo;
        this.bill = bill;
    }

    /**
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setOwnerId(int ownerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the Bill
     */
    public float getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(float bill) {
        this.bill = bill;
    }
}
