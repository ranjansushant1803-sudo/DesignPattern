package LLD.Designs.FitnessApp;

public class Booking {
    String id;
    private User user;
    private Centre centre;
    private ActivitySlot activitySlot;
    private BookingStatus status;

    public Booking(String id, User user, Centre centre, ActivitySlot activitySlot){
        this.id = id;
        this.user = user;
        this.centre = centre;
        this.activitySlot = activitySlot;
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

}
