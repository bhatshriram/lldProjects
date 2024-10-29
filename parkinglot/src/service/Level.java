package service;

import java.util.ArrayList;
import java.util.List;
import models.Vehicle;
import models.VehicleType;

public class Level {

    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floorNumber, int numSpots) {
        this.floorNumber=floorNumber;
        this.parkingSpots= new ArrayList<>(numSpots);

        double bikeSpots= 0.5;
        double carSpots= 0.4;

        int numBikeSpots= (int) (bikeSpots*numSpots);
        int numCarSpots= (int) (carSpots*numSpots);

        for(int i=1;i<=numBikeSpots;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTOR_CYCLE));
        }

        for(int i=numBikeSpots+1;i<=numBikeSpots+numCarSpots;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for(int i=numBikeSpots+numCarSpots+1;i<=numSpots;i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {

        for(ParkingSpot spot: parkingSpots) {
            if(spot.isAvailable() && spot.getVehicleType()==vehicle.getVehicleType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {

        for(ParkingSpot spot: parkingSpots) {
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }

        return false;
    }

    public void printAvailability() {
        System.out.println("floorNumber: "+floorNumber);

        for(ParkingSpot spot: parkingSpots) {
            if(spot.isAvailable()) {
                System.out.println("Spot Number: "+spot.getSpotNumber()+ " of type: "+spot.getVehicleType()+ " availability: " +spot.isAvailable());
            }
        }
    }
}
