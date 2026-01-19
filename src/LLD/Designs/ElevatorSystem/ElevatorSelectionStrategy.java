package LLD.Designs.ElevatorSystem;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(int requestedFloor, ElevatorDirection direction, List<ElevatorController> elevatorControllers);
}
