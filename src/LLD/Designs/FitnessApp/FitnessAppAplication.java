package LLD.Designs.FitnessApp;

public class FitnessAppAplication {
    public static void main(String[] args) {
        FitnessApp app = new FitnessApp();

        // Setup
        Location koramangala = new Location("Koramangala");
        Location indiranagar = new Location("Indiranagar");

        // Add centers
        Centre gym1 = app.addNewCenter(1,"PowerGym Kormanangala", koramangala);
        gym1.addActivity(ActivityName.GYM, new TimeSlot(7, 8), 2);

        Centre yoga1 = app.addNewCenter(2,"Yoga Studio Indiranagar", indiranagar);
        yoga1.addActivity(ActivityName.YOGA, new TimeSlot(6, 7), 2);

        // Add users
        Location userLoc = new Location("Koramangala");
        User sushant = new User(1, "Sushant", userLoc);
        app.addNewUser(sushant);

        User bhaskar = new User(2, "Bhaskar", userLoc);
        app.addNewUser(bhaskar);

        User anurag = new User(3, "Anurag", userLoc);
        app.addNewUser(anurag);

        // Demo 1: Find nearby gyms
        System.out.println("🏠 Nearby Gyms:");
        for (Centre c : app.findNearbyCenters(userLoc, ActivityName.GYM)) {
            System.out.println("  → " + c.getName());
        }

        // Demo 2: Bookings
        System.out.println("\n📅 Bookings:");
        Booking sushantBooking = app.bookActivity("Sushant", "PowerGym Kormanangala", "GYM");  // Sushant books
        Booking bhaskarBooking = app.bookActivity("Bhaskar", "PowerGym Kormanangala", "GYM");  // Bhaskar books
        Booking anuragBooking = app.bookActivity("Anurag", "PowerGym Kormanangala", "GYM");  // Anurag waitlist

        // Demo 3: Cancel
        System.out.println("\n❌ Cancel:");
        app.cancelBooking("B-0");// Sushant cancels -> Anurag gets promoted
    }
}
