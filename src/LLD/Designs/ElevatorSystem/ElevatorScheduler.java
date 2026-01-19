package LLD.Designs.ElevatorSystem;

import java.util.List;

public class ElevatorScheduler {
    private List<ElevatorController> elevatorControllers;
    private ElevatorSelectionStrategy selectionStrategy;

    public ElevatorScheduler(List<ElevatorController> elevatorControllers, ElevatorSelectionStrategy selectionStrategy) {
        this.elevatorControllers = elevatorControllers;
        this.selectionStrategy = selectionStrategy;
    }

    public void setSelectionStrategy(ElevatorSelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    public void assignElevator(int requestedFloor, ElevatorDirection direction) {
        ElevatorController selectedElevatorController = selectionStrategy.selectElevator(requestedFloor, direction, elevatorControllers);
        if (selectedElevatorController != null) {
            System.out.println("Assigned Elevator " + selectedElevatorController.getElevatorCar().getId() + " to move to floor " + requestedFloor);
            selectedElevatorController.submitRequest(requestedFloor);
        } else {
            System.out.println("No available elevator to assign for floor " + requestedFloor);
        }
    }





}
