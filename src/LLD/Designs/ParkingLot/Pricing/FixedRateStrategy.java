package LLD.Designs.ParkingLot.Pricing;

import LLD.Designs.ParkingLot.Parking.ParkingTicket;

public class FixedRateStrategy implements PricingStrategy {
    private final double flatRate;
    public FixedRateStrategy(double flatRate){
        this.flatRate = flatRate;
    }

    @Override
    public double calculate(ParkingTicket ticket) {
        return flatRate;
    }
}
