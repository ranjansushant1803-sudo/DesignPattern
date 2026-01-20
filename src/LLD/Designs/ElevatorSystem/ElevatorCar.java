package LLD.Designs.ElevatorSystem;

public class ElevatorCar {
    private int id;
    private int currentFloor;
    private int nextStopFloor;
    private ElevatorDirection direction;

    public ElevatorCar(int id) {
        this.id = id;
        this.currentFloor = 0; // assuming ground floor as starting point
        this.direction = ElevatorDirection.IDLE;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
         this.currentFloor = currentFloor;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public int getNextStopFloor() {
        return nextStopFloor;
    }

    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }

    public void moveToFloor(int targetFloor) {
        this.nextStopFloor = targetFloor;
        int startFloor = currentFloor;
        if (nextStopFloor > currentFloor) {
            direction = ElevatorDirection.UP;
            displayStatus();
            for (int i = startFloor+1; i<= nextStopFloor; i++) {
                try {
                    Thread.sleep(5);
                }catch (Exception e) {

                }
                setCurrentFloor(i);
                displayStatus();
            }

        } else if (nextStopFloor < currentFloor) {
            direction = ElevatorDirection.DOWN;
            displayStatus();
            for (int i = startFloor+1; i<= nextStopFloor; i++) {
                try {
                    Thread.sleep(5);
                }catch (Exception e) {

                }
                setCurrentFloor(i);
                displayStatus();
            }
        } else {
            direction = ElevatorDirection.IDLE;
        }
    }

    public void displayStatus() {
        System.out.println("Elevator ID: " + id+ " Current Floor: " + currentFloor + " going : " + direction);
    }
}
