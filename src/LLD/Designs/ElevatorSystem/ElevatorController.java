package LLD.Designs.ElevatorSystem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {
    private ElevatorCar elevatorCar;
    private PriorityBlockingQueue<Integer> upDestinationQueue;
    private PriorityBlockingQueue<Integer> downDestinationQueue;
    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        this.upDestinationQueue = new PriorityBlockingQueue<>();
        this.downDestinationQueue = new PriorityBlockingQueue<>(10,(a, b) -> b-a);
    }

    public void submitRequest(int targetFloor) {
        System.out.println("Request details-> destinationFloor: " + targetFloor + " accepted by elevator:" + elevatorCar.getId());
        if (targetFloor > elevatorCar.getNextStopFloor()) {
            if(!upDestinationQueue.contains(targetFloor))
                upDestinationQueue.offer(targetFloor);
        } else if (targetFloor < elevatorCar.getNextStopFloor()) {
            if (!downDestinationQueue.contains(targetFloor))
                downDestinationQueue.offer(targetFloor);
        }
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public PriorityBlockingQueue<Integer> getUpDestinationQueue() {
        return upDestinationQueue;
    }

    public PriorityBlockingQueue<Integer> getDownDestinationQueue() {
        return downDestinationQueue;
    }

    @Override
    public void run() {
        controlElevator();
    }

    public void controlElevator() {
        while (true) {
            while (!upDestinationQueue.isEmpty()) {
                int nextFloor = (int) upDestinationQueue.poll();
                System.out.println("Moving elevator "+elevatorCar.getId()+" to floor " + nextFloor);
                elevatorCar.moveToFloor(nextFloor);
            }
            while (!downDestinationQueue.isEmpty()) {
                int nextFloor = (int) downDestinationQueue.poll();
                System.out.println("Moving elevator "+elevatorCar.getId()+" to floor " + nextFloor);
                elevatorCar.moveToFloor(nextFloor);
                System.out.println("On floor");
            }
            try {
                Thread.sleep(1000);// Pause before checking for new requests
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
