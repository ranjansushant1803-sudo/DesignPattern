package LLD.Designs.ParkingLot.Parking;

import LLD.Designs.ParkingLot.NoSpaceException;
import LLD.Designs.ParkingLot.Vehicle.Vehicle;

public class EntryGate {
    private ParkingLot parkingLot;
    private String entryGateId;

    public EntryGate(ParkingLot parkingLot, String entryGateId){
        this.parkingLot = parkingLot;
        this.entryGateId = entryGateId;
    }

    public ParkingTicket processEntry(Vehicle vehicle) throws NoSpaceException {
        return parkingLot.park(vehicle);
    }

    public String getEntryGateId(){
        return entryGateId;
    }

}
