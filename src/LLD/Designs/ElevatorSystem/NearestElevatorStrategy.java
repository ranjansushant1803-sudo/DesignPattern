package LLD.Designs.ElevatorSystem;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(int requestedFloor, ElevatorDirection direction, List<ElevatorController> elevatorControllers) {
        ElevatorController nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllers) {
            int nextStopFloor = controller.getElevatorCar().getNextStopFloor();

            boolean isSameDirection = controller.getElevatorCar().getDirection() == direction && ((direction==ElevatorDirection.UP && nextStopFloor >= requestedFloor) || (direction==ElevatorDirection.DOWN && nextStopFloor <= requestedFloor));

            int dist = Math.abs(nextStopFloor - requestedFloor);

            if(isSameDirection && dist < minDistance) {
                minDistance = dist;
                nearestElevator = controller;
            }

        }

        if(nearestElevator == null)//if no elevator is moving in the requested direction, return an idle elevator
        {
            return elevatorControllers.stream().filter(controller ->
                controller.getElevatorCar().getDirection() == ElevatorDirection.IDLE).findFirst().orElse(null);
        }

        if(nearestElevator == null) {//if no idle elevator, return the first elevator (could implement better logic here)
            nearestElevator = elevatorControllers.get(0);
        }

        System.out.println("Nearest Elevator selected: " + nearestElevator.getElevatorCar().getId());

        return nearestElevator;
    }
}
