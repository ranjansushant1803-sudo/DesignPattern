package LLD.Designs.FitnessApp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class FitnessApp {
    private List<Centre> centres;
    private List<User> users;
    private List<Booking> bookings;

    public FitnessApp(){
        centres = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public Centre addNewCenter(int id,String name, Location location){
        Centre centre = new Centre(id,name,location);
        centres.add(centre);
        return centre;
    }

    public void addNewUser(User user){
        users.add(user);
    }

    public List<Centre> findNearbyCenters(Location userLocation,ActivityName activityName){

        List<Centre> nearby = new ArrayList<>();
        for(Centre centre:centres){
            ActivitySlot slot = centre.getSlot(activityName.name());
            if(slot.hasSpace())
                nearby.add(centre);

            nearby.sort((c1,c2) -> {
                double d1 = c1.getLocation().distanceTo(userLocation);
                double d2 = c2.getLocation().distanceTo(userLocation);
                return Double.compare(d1,d2);
            });
        }
        return nearby;
    }

    public Booking bookActivity(String userName,String centreName,String activityName){
        User user = findUsers(userName);
        if(user==null) {
            System.out.println("No user found");
            return null;
        }
        Centre centre = findCentre(centreName);
        if(centre==null){
            System.out.println("No centre found");
            return null;
        }

        ActivitySlot slot = centre.getSlot(activityName);
        if(slot==null){
            System.out.println("Activity not found");
            return null;
        }

        if(user.hasConflict(slot.getTimeSlot())){
            System.out.println("Time Conflict");
            return null;
        }

        boolean booked = slot.book(user);
        String status = booked ? "BOOKED":"WAITING";
        String bookingId = "B-"+bookings.size();
        Booking booking = new Booking(bookingId,user,centre,slot);
        bookings.add(booking);
        user.getBookings().add(booking);
        System.out.println("User "+user.getUserName()+" booking status "+status+" : "+activityName);
        return booking;
    }

    public String cancelBooking(String bookingId){
        for(Booking b:bookings){
            if(b.getId().equals(bookingId)){
                User user = b.getUser();
                b.getActivitySlot().cancel(user);
                b.setStatus(BookingStatus.CANCELLED);
                return "User "+user.getUserName()+" cancelled booking for "+b.getActivitySlot().getActivityName();
            }
        }
        return "Booking not found";
    }

    public User findUsers(String userName){
        for(User user:users){
            if(user.getUserName().equals(userName))
                return user;
        }
        return null;
    }

    public Centre findCentre(String centreName){
        for(Centre centre:centres){
            if(centre.getName().equals(centreName))
                return centre;
        }
        return null;
    }



}
