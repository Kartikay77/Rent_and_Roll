/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Car {
    
    private int carId;
    private String carModel;
    private int seatingCapacity;
    private float rentPerHour;
    private int carOwnerId;
    private String carOwnerName;
    private String makerName;
    private String carName;
    private String color;
    private String carType;
    private String carCondition;
    private String carRegNo;
    
    
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
     * @return the Marker Name
     */
    
        public String getMakerName() {
        return makerName;
    }

    /**
     * @param markerName the markerName to set
     */
    public void setMakerName(String markerName) {
        this.makerName = markerName;
    }
    
    
            /**
     * @return the carName
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
     * @return the color
     */
    
        public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    
     /**
     * @return the Marker Name
     */
    
        public String getCarType() {
        return carType;
    }

    /**
     * @param carType the carType to set
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }
    
       /**
     * @return the Marker Name
     */
    
        public String getCarCondition() {
        return carCondition;
    }

    /**
     * @param carCondition the carCondition to set
     */
    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }
    
    
    /**
     * @param carRegNo the carRegNo to set
     */
    public void setCarRegNo(String carRegNo) {
        this.carRegNo = carRegNo;
    }
    
                /**
     * @return the carRegNo
     */
    
        public String getCarRegNo() {
        return carRegNo;
    }
        
    /**
     * @return the carModel
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * @param carModel the ownerName to set
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    /**
     * @return the seatingCapacity
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * @param seatingCapacity the seatingCapacity to set
     */
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * @return the rentPerHour
     */
    public float getRentPerHour() {
        return rentPerHour;
    }

    /**
     * @param rentPerHour set the rentPerHour
     */
    public void setRentPerHour(float rentPerHour) {
        this.rentPerHour = rentPerHour;
    }
    
    /**
     * @return the carOwnerId
     */
    public int getCarOwnerId() {
        return carOwnerId;
    }

    /**
     * @param carOwnerId the carOwnerId to set
     */
    public void setcarOwnerID(int carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    /**
     * @return the carOwnerName
     */
    public String getCarOwnerName() {
        return carOwnerName;
    }

    /**
     * @param carOwnerName the carOwnerName to set
     */
    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }
    
    @Override
    public String toString() {
    	return ("Reg No: " + this.carRegNo + " Name: " + this.carName + " Maker: " + this.makerName);
    }
}
