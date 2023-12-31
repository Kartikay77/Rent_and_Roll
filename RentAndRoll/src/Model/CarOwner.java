/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * The CarOwner is the model class for a CarOwner object.
 */
public class CarOwner implements Serializable{
    private int ownerId;
    private String  ownerName;
    private String phoneNo;
    private float balance_due;

    public CarOwner(int ownerId, String ownerName, String phoneNo, float balance_due) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.phoneNo = phoneNo;
        this.balance_due = balance_due;
    }
    public CarOwner() {}
    /**
     * @return the ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
     * @return the balance due
     */
    public float getBalanceDue() {
        return balance_due;
    }

    /**
     * @param balance_due set the balance due
     */
    public void setBalanceDue(float balance_due) {
        this.balance_due = balance_due;
    }
    
    @Override
    public String toString(){
        return ("ID: " + this.ownerId + " Name: " + this.ownerName + " Contact: " + this.phoneNo + " Balance: " + this.balance_due);
    }
}
