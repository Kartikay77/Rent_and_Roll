/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Booking {
    private int bookingId;
    private int customerId;
    private int carId;
    private Date rentalStartTime, rentalReturnTime;
    private String carName;
    private String carRegNo;
    private String customerName; 
    
    /**
     * @return the carID
     */
    public int bookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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
     * @return the carID
     */
    public int carId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(int carId) {
        this.carId = carId;
    }
    
    /**
     * @return the rentalStartTime
     */
    public Date getRentalStartTime() {
        return rentalStartTime;
    }

    /**
     * @param rentalStartTime the rentalStartTime to set
     */
    public void setRentalStartTime(Date rentalStartTime) {
        this.rentalStartTime = rentalStartTime;
    }
    
    /**
     * @return the rentalReturnTime
     */
    public Date getRentalReturnTime() {
        return rentalReturnTime;
    }

    /**
     * @param rentalReturnTime the rentalReturnTime to set
     */
    public void setRentalReturnTime(Date rentalReturnTime) {
        this.rentalReturnTime = rentalReturnTime;
    }
    
    /**
     * @return the car name
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @param carName the carName to set
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }
        /**
     * @return the carRegNo
     */
    public String getReg_No() {
        return carRegNo;
    }

    /**
     * @param carRegNo the carRegNo to set
     */
    public void setReg_No(String carRegNo) {
        this.carRegNo = carRegNo;
    }
    
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
    public String toString() {
    	return ("ID: " + this.bookingId + " Car: " + this.carName + " Customer: " + this.customerName);
    }
}
