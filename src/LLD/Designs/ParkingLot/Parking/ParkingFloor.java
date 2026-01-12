package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(int twoWheelerSpots,int fourWheelerSpots){
        for (int i = 0; i < twoWheelerSpots; i++) {
            spots.add(new TwoWheelerParkingSpot());
        }
        for (int i = 0; i < fourWheelerSpots; i++) {
            spots.add(new FourWheelerParkingSpot());
        }
    }

    public List<ParkingSpot> getAvailableSpots(Vehicle vehicle){
        return spots.stream().filter(s -> s.isFree && s.canPark(vehicle)).toList();
    }

    public ParkingSpot getNearestAvailableSpots(Vehicle vehicle){
        return spots.stream().filter(s -> s.isFree && s.canPark(vehicle)).findFirst()
                .orElse(null);
    }

}
