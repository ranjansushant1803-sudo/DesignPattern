package LLD.Designs.VehicleRentalSystem;

public class Location {

    private String area;
    private String city;

    public Location(String area,String city)
    {
        this.area = area;
        this.city = city;
    }

    public double distanceTo(Location other) {
        // Fake distance based on area
        return Math.random() * 5 + 1; // 1-6 km
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }
}
