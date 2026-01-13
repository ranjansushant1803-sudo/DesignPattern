package LLD.Designs.ParkingLot;

import LLD.Designs.ParkingLot.Parking.EntryGate;
import LLD.Designs.ParkingLot.Parking.ParkingFloor;
import LLD.Designs.ParkingLot.Parking.ParkingLot;
import LLD.Designs.ParkingLot.Parking.ParkingTicket;
import LLD.Designs.ParkingLot.Pricing.HourlyRateStrategy;
import LLD.Designs.ParkingLot.Pricing.PricingStrategy;
import LLD.Designs.ParkingLot.Vehicle.Bike;
import LLD.Designs.ParkingLot.Vehicle.Car;

import java.util.List;

public class ParkingLotApplication {
    public static void main(String[] args) {
        /*Assumed scope (common interview scope):
        Vehicles: Car, Bike, Truck
        Spots: Small (Bike/Car), Large (Truck)
        Multi-floor, each floor has fixed spots
        Generate ticket on entry, pay on exit*/

        List<ParkingFloor> floors = List.of(
                new ParkingFloor(10, 2),  // Floor 1: 10 small, 2 large spots
                new ParkingFloor(8, 3),   // Floor 2: 8 small, 3 large spots
                new ParkingFloor(12, 1)   // Floor 3: 12 small, 1 large spot
        );
        PricingStrategy hourly = new HourlyRateStrategy(50.0); // ₹50/hour

        try {
            ParkingLot mallLot = new ParkingLot(
                    floors,
                    hourly,
                    5,  // 5 Entry gates
                    3   // 3 Exit gates
            );
            Car car = new Car("KA-01-AB-1234");
            EntryGate gate1 = mallLot.getEntryGate(0);
            ParkingTicket ticket = gate1.processEntry(car);
            System.out.println("✅ Parked car, Ticket ID: " + ticket.getTicketId());
            Thread.sleep(2000);
            mallLot.unpark(ticket.getTicketId());

            Bike bike = new Bike("BA-01-KA-1234");
            EntryGate gate4 = mallLot.getEntryGate(4);
            ParkingTicket ticket1 = gate4.processEntry(bike);
            System.out.println("✅ Parked bike, Ticket ID: " + ticket1.getTicketId());
            Thread.sleep(1000);
            mallLot.unpark(ticket1.getTicketId());
        }
        catch(Exception e){

        }
    }
}
