package LLD.Designs.ParkingLot.Parking;

public class ExitGate {
    private ParkingLot parkingLot;
    private String exitGateId;

    public ExitGate(ParkingLot parkingLot,String exitGateId){
        this.parkingLot = parkingLot;
        this.exitGateId = exitGateId;
    }

    public void processExit(ParkingTicket ticket){
        parkingLot.unpark(ticket.getTicketId());
    }

    public String getExitGateId(){
        return exitGateId;
    }
}
