package LLD.Designs.FitnessApp;

public class Location {
    private String area;
    public Location(String area)
    {
        this.area = area;
    }

    public double distanceTo(Location other) {
        // Fake distance based on area
        return Math.random() * 5 + 1; // 1-6 km
    }
}
