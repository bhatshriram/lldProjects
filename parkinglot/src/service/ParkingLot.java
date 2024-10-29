package service;

import java.util.ArrayList;
import java.util.List;
import models.Vehicle;

public class ParkingLot {

    private List<Level> levels;

    private ParkingLot() {
        levels= new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        return helper.parkingLot;
    }

    private static class helper {
        public static final ParkingLot parkingLot = new ParkingLot();;
    }

    public void addLevels(Level level) {
        this.levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.parkVehicle(vehicle)) {
                System.out.println("Vehicle is parked!");
                return true;
            }
        }
        System.out.println("Parking is full!");
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            if(level.unParkVehicle(vehicle)) {
                System.out.println("Vehicle is un parked!");
                return true;
            }
        }

        return false;
    }

    public void displayAvailability() {
        for(Level level: levels) {
            level.printAvailability();
        }
    }
}
