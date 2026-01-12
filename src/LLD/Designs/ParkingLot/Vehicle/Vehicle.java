package LLD.Designs.ParkingLot.Vehicle;

public class Vehicle {
    private String vehicleNo;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNo,VehicleType vehicleType){
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
