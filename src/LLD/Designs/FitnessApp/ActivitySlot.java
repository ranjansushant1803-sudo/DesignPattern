package LLD.Designs.FitnessApp;

import java.util.Deque;
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

    public Deque<User> getWaitList() {
        return waitList;
    }

    public ActivitySlot(ActivityName activityName, TimeSlot timeSlot, int capacity){
        this.activityName = activityName;
        this.timeSlot = timeSlot;
        this.capacity = capacity;
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

    public void cancel(User user){
        if(bookedCount.decrementAndGet()>=0)
        {
            User nextUser = waitList.pollFirst();
            if(nextUser!=null)
                bookedCount.incrementAndGet();
        }
    }

}
