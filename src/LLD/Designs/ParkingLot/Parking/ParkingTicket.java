package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.Pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketId = UUID.randomUUID().toString();
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingSpot spot;
    private PricingStrategy strategy;

    public ParkingTicket(ParkingSpot spot, PricingStrategy strategy){
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.strategy = strategy;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public ParkingSpot getSpot(){
        return spot;
    }

    public void setExitTime(){
        this.exitTime = LocalDateTime.now();
    }

    public double calculateFee(){
        if (exitTime == null) {
            throw new IllegalStateException("Cannot calculate fee before exit");
        }
        return strategy.calculate(this);
    }

}
