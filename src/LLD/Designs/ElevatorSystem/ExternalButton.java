package LLD.Designs.ElevatorSystem;

public class ExternalButton {
    private ElevatorScheduler elevatorScheduler;

    public ExternalButton(ElevatorScheduler elevatorScheduler) {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void press(int floorNumber, ElevatorDirection direction) {
        System.out.println("External button for floor " + floorNumber + " pressed to go " + direction);
        elevatorScheduler.assignElevator(floorNumber, direction);
    }
}
