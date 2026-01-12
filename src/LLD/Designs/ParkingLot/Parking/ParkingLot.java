package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.NoSpaceException;
import LLD.Designs.ParkingLot.Pricing.PricingStrategy;
import LLD.Designs.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<EntryGate> entryGates=new ArrayList<>();
    private List<ExitGate> exitGates=new ArrayList<>();
    private List<ParkingFloor> floors;
    private Map<String, ParkingTicket> tickets = new HashMap<>();
    private PricingStrategy strategy;

    public ParkingLot(List<ParkingFloor> floors, PricingStrategy strategy, int numEntryGates, int numExitGates){
        this.floors = floors;
        this.strategy = strategy;
        for(int i=1;i<=numEntryGates;i++)
        {
            EntryGate entryGate = new EntryGate(this,"Entry Gate - "+i);
            entryGates.add(entryGate);
        }
        for(int i=1;i<=numExitGates;i++)
        {
            ExitGate exitGate = new ExitGate(this,"Entry Gate - "+i);
            exitGates.add(exitGate);
        }
    }

    public ParkingTicket park(Vehicle vehicle) throws NoSpaceException {
        for(ParkingFloor floor : floors){
            List<ParkingSpot> spots = floor.getAvailableSpots(vehicle);
            if(!spots.isEmpty()){
                ParkingSpot spot = spots.get(0);
                ParkingTicket parkingTicket = spot.park(vehicle,strategy);
                tickets.putIfAbsent(parkingTicket.getTicketId(), parkingTicket);
                return parkingTicket;
            }
            else
                throw new NoSpaceException("No space to park vehicle");
        }
        return null;
    }

    public void unpark(String ticketID){
        ParkingTicket parkingTicket = tickets.remove(ticketID);
        if (parkingTicket == null) {
            throw new RuntimeException("Invalid ticket");
        }
        parkingTicket.setExitTime();
        parkingTicket.getSpot().unpark(ticketID);
        System.out.println("Total amount to be paid: "+parkingTicket.calculateFee());
    }

    public List<EntryGate> getEntryGates() { return entryGates; }
    public List<ExitGate> getExitGates() { return exitGates; }

    public EntryGate getEntryGate(int index){
        return entryGates.get(index);
    }
}
