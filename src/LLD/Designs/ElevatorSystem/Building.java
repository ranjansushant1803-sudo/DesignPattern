package LLD.Designs.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors = new ArrayList<>();

    public Building(int totalfloors, ElevatorScheduler elevatorScheduler) {
        for(int i=1;i<=totalfloors;i++) {
            floors.add(new Floor(i, elevatorScheduler));
        }
    }

    public Floor getFloor(int floorNumber) {
        return floors.get(floorNumber-1);
    }

}
