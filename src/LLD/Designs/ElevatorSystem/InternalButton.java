package LLD.Designs.ElevatorSystem;

public class InternalButton {
    private ElevatorController elevatorController;

    public InternalButton(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public void pressButton(int floorNumber) {
        System.out.println("Internal button for floor " + floorNumber + " pressed in Elevator " + elevatorController.getElevatorCar().getId());
        elevatorController.submitRequest(floorNumber);
    }
}
