package LLD.Designs.FitnessApp;

public class TimeSlot {
    private int startHour;
    private int endHour;

    public TimeSlot(int startHour,int endHour){
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public boolean isOverlapping(TimeSlot other){
        return !(endHour <= other.getStartHour() || startHour >= other.getEndHour());
    }
}
