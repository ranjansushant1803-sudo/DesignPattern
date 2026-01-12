package LLD.Designs.ParkingLot.Pricing;

import LLD.Designs.ParkingLot.Parking.ParkingTicket;

public interface PricingStrategy {
    double calculate(ParkingTicket ticket);
}
