package LLD.Designs.ParkingLot;

public class NoSpaceException extends Exception{
    public NoSpaceException(String msg){
        super(msg);
    }
}
