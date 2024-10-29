package models;

public abstract class Vehicle {

    protected String licensePlate;
    protected VehicleType vehicleType;

    Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate=licensePlate;
        this.vehicleType=vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
