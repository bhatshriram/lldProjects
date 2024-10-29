package service;

import models.Vehicle;
import models.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {

        if(isAvailable() && vehicle.getVehicleType()==vehicleType) {
            this.parkedVehicle= vehicle;
        } else {
            throw new IllegalArgumentException("Spot already occupied or invalid vehicle type.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle=null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
