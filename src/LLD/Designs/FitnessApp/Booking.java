package LLD.Designs.FitnessApp;

public class Booking {
    String id;
    private User user;
    private Centre centre;
    private ActivitySlot activitySlot;
    private BookingStatus status;

    public Booking(String id, User user, Centre centre, ActivitySlot activitySlot,BookingStatus status){
        this.id = id;
        this.user = user;
        this.centre = centre;
        this.activitySlot = activitySlot;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Centre getCentre() {
        return centre;
    }

    public ActivitySlot getActivitySlot() {
        return activitySlot;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void displayBookingDetails(){
        System.out.println("Booking ID: " + id);
        System.out.println("User: " + user.getUserName());
        System.out.println("Centre: " + centre.getName());
        System.out.println("Activity: " + activitySlot.getActivityName());
        System.out.println("Status: " + status);
    }

}
