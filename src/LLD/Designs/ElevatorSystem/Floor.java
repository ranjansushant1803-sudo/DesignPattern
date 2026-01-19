package LLD.Designs.ElevatorSystem;

public class Floor {
    private int floorNumber;
    private ExternalButton externalButtonUp;
    private ExternalButton externalButtonDown;

    public Floor(int floorNumber, ElevatorScheduler elevatorScheduler) {
        this.floorNumber = floorNumber;
        this.externalButtonUp = new ExternalButton(elevatorScheduler);
        this.externalButtonDown = new ExternalButton(elevatorScheduler);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void pressUpButton() {
        System.out.println("button pressed for up");
        externalButtonUp.press(floorNumber, ElevatorDirection.UP);
    }

    public void pressDownButton() {
        System.out.println("button pressed for down");
        externalButtonDown.press(floorNumber, ElevatorDirection.DOWN);
    }
}
