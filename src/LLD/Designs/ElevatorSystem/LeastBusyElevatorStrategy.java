package LLD.Designs.ElevatorSystem;

import java.util.List;

public class LeastBusyElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(int requestedFloor, ElevatorDirection direction, List<ElevatorController> elevatorControllers) {
        ElevatorController leastBusyElevator = null;
        int minLoad = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllers) {
            int load = controller.getUpDestinationQueue().size() + controller.getDownDestinationQueue().size();
            if(load<minLoad) {
                minLoad = load;
                leastBusyElevator = controller;
            }
        }
        return leastBusyElevator;
    }
}
