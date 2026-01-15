package LLD.Designs.FitnessApp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private Location location;
    List<Booking> bookings;

    public User(int userId,String userName,Location location){
        this.userId = userId;
        this.userName = userName;
        this.location = location;
        this.bookings = new ArrayList<>();
    }

    public boolean hasConflict(TimeSlot timeSlot){
        for(Booking b:bookings){
            if(b.getStatus()==BookingStatus.BOOKED && timeSlot.isOverlapping(b.getActivitySlot().getTimeSlot())){
                return true;
            }
        }
        return false;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public String getUserName() {
        return userName;
    }

    public Location getLocation() {
        return location;
    }

    public int getUserId() {
        return userId;
    }
}
