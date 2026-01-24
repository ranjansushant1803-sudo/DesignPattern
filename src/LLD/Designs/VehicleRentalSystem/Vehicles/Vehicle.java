package LLD.Designs.VehicleRentalSystem.Vehicles;

public class Vehicle {
    private int vehicleId;
    private String vehicleNo;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;
    private double dailyRentalCost;

    public Vehicle(int vehicleId,String vehicleNo, VehicleType vehicleType,double dailyRentalCost) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.dailyRentalCost = dailyRentalCost;
        this.vehicleStatus = VehicleStatus.Available;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleStatus isAvailable(){
        return vehicleStatus;
    }


}
