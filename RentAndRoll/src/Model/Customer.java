/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

public class Customer implements Serializable{
    private int customerId;
    private String  customerName;
    private String phoneNo;
    private float bill_amt;

    Customer() {}
    public Customer(int customerId, String customerName, String phoneNo, float bill_amt) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.bill_amt = bill_amt;
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
    public void setCustomerId(int customerId) {
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
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the contactNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the Bill amount
     */
    public float getBillAmount() {
        return bill_amt;
    }

    /**
     * @param bill_amt the bill amount to set
     */
    public void setBillAmount(float bill_amt) {
        this.bill_amt = bill_amt;
    }
}
