import models.Car;
import models.MotorCycle;
import models.Truck;
import models.Vehicle;
import service.Level;
import service.ParkingLot;

public class ParkingLotMain {

    public static void main(String[] args) {

        ParkingLot parkingLot= ParkingLot.getInstance();

        Level level1= new Level(1, 10);
        parkingLot.addLevels(level1);
        Level level2= new Level(2, 6);
        parkingLot.addLevels(level2);
        parkingLot.displayAvailability();

        Vehicle vehicle1= new Car("KA02AA1111");
        Vehicle vehicle2= new MotorCycle("KA01BB1111");
        Vehicle vehicle3= new Truck("KA03CC1111");

        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);
        parkingLot.parkVehicle(vehicle3);

        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(vehicle3);

        parkingLot.displayAvailability();
    }
}