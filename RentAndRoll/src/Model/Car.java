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
}
