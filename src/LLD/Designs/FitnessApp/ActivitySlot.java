package LLD.Designs.FitnessApp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivitySlot {
    private ActivityName activityName;
    private TimeSlot timeSlot;
    private int capacity;
    private AtomicInteger bookedCount;
    private Deque<User> waitList;

    public ActivityName getActivityName() {
        return activityName;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public int getCapacity() {
        return capacity;
    }

    public AtomicInteger getBookedCount() {
        return bookedCount;
    }

    public Deque<User> getWaitingList() {
        return waitList;
    }

    public ActivitySlot(ActivityName activityName, TimeSlot timeSlot, int capacity){
        this.activityName = activityName;
        this.timeSlot = timeSlot;
        this.capacity = capacity;
        this.bookedCount = new AtomicInteger(0);
        this.waitList = new LinkedList<>();
    }

    public boolean hasSpace(){
        return bookedCount.get() < capacity;
    }

    public boolean book(User user){
        if(hasSpace()){
            bookedCount.incrementAndGet();
            return true;
        }
        waitList.addLast(user);
        return false;
    }

    public boolean cancel(User user){
        if(bookedCount.decrementAndGet()>=0)
        {
            return true;
        }
        return false;
    }

}
