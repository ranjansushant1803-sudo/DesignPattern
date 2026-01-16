package LLD.Designs.FitnessApp;

import java.util.ArrayList;
import java.util.List;

public class Centre {
    private int id;
    private String name;
    private List<ActivitySlot> activities;
    private Location location;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ActivitySlot> getActivities() {
        return activities;
    }

    public Location getLocation() {
        return location;
    }

    public Centre(int id, String name, Location location)
    {
        this.id = id;
        this.name = name;
        this.location = location;
        activities = new ArrayList<>();
    }

    public void addActivity(ActivityName activityName,TimeSlot timeSlot,int capacity){
        activities.add(new ActivitySlot(activityName,timeSlot,capacity));
    }

    public ActivitySlot getSlot(String name){
        for(ActivitySlot activitySlot:activities){
            if(activitySlot.getActivityName().toString().equals(name)){
                return activitySlot;
            }
        }
        return null;
    }
}
