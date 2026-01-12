package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.Pricing.PricingStrategy;
import LLD.Designs.ParkingLot.Vehicle.Vehicle;
import LLD.Designs.ParkingLot.Vehicle.VehicleType;

public class FourWheelerParkingSpot extends ParkingSpot {
    @Override
    public boolean canPark(Vehicle vehicle) {
        return isFree && vehicle.getVehicleType() == VehicleType.FOUR_WHEELER;
    }

    @Override
    public ParkingTicket park(Vehicle vehicle, PricingStrategy strategy) {
        isFree = false;
        ParkingTicket parkingTicket = new ParkingTicket(this,strategy);
        return parkingTicket;
    }

    @Override
    public void unpark(String ticketId) {
        isFree = false;
    }
}
