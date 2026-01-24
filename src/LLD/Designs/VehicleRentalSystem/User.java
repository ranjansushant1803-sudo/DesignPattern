package LLD.Designs.VehicleRentalSystem;

public class User {
    private int userId;
    private String userName;
    private String drivingLicenseNumber;

    public User(int userId, String userName, String drivingLicenseNumber) {
        this.userId = userId;
        this.userName = userName;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }
}
