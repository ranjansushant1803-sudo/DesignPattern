package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.Pricing.PricingStrategy;
import LLD.Designs.ParkingLot.Vehicle.Vehicle;

public abstract class ParkingSpot {
    protected boolean isFree=true;

    public abstract boolean canPark(Vehicle vehicle);
    public abstract ParkingTicket park(Vehicle vehicle, PricingStrategy strategy);
    public abstract void unpark(String ticketId);

}
