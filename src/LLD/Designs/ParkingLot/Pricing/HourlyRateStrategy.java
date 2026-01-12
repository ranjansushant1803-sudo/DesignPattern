package LLD.Designs.ParkingLot.Pricing;

import LLD.Designs.ParkingLot.Parking.ParkingTicket;

import java.time.Duration;

public class HourlyRateStrategy implements PricingStrategy {

    private final double ratePerHour;
    public HourlyRateStrategy(double ratePerHour){
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculate(ParkingTicket ticket) {
        long totalNoHours = Duration.between(ticket.getEntryTime(),ticket.getExitTime()).toSeconds();
        return totalNoHours*ratePerHour;
    }
}
