package LLD.Designs.VehicleRentalSystem;

import LLD.Designs.VehicleRentalSystem.Bills.Bill;
import LLD.Designs.VehicleRentalSystem.Bills.DailyBillingStategy;
import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;
import LLD.Designs.VehicleRentalSystem.Bookings.ReservationType;
import LLD.Designs.VehicleRentalSystem.Payments.Payment;
import LLD.Designs.VehicleRentalSystem.Payments.PaymentMode;
import LLD.Designs.VehicleRentalSystem.Payments.UPIPaymentStrategy;
import LLD.Designs.VehicleRentalSystem.Vehicles.Vehicle;
import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleType;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Rental System!");

        //List of stores
        //list of users
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();

        Location store1Location = new Location("123 Main St", "Springfield");

        Store store1 = new Store(1001, "Downtown Store", store1Location);
        vehicleRentalSystem.addStore(store1);

        User user1 = new User(801, "SJ", "DL2022GDG556690");
        User user2 = new User(802, "DJ", "DL2017DHW9090765231");
        vehicleRentalSystem.addUser(user1);
        vehicleRentalSystem.addUser(user2);

        Vehicle v1 = new Vehicle(1, "DL1234", VehicleType.Four_Wheeler,1100);

        Vehicle v2 = new Vehicle(2, "DL5678", VehicleType.Four_Wheeler,1400);

        store1.getInventory().addVehicle(v1);
        store1.getInventory().addVehicle(v2);

        Store selectedStore = vehicleRentalSystem.getStore(1001);

        Date fromDate = new Date(2025, 12, 1);
        Date toDate   = new Date(2025, 12, 7);

        System.out.println("\nAvailable vehicles from " + fromDate + " to " + toDate + ":");

        for (Vehicle v : selectedStore.getAvailableVehicles(VehicleType.Four_Wheeler, fromDate, toDate)) {
            System.out.println(" - " + v.getVehicleId() + ": " + v.getVehicleType() + ": daily cost " + v.getDailyRentalCost());
        }

        System.out.println("\nCreating reservation...");

        Reservation reservation = selectedStore.createReservation(
                        1,                // vehicle ID
                        801,
                        fromDate,
                        toDate,
                ReservationType.Daily
                );

        System.out.println("Reservation created with ID: " + reservation.getReservationId());


        // ---------------------------------------------------------
        // 6. User starts the trip
        // ---------------------------------------------------------
        System.out.println("\nStarting trip...");
        selectedStore.startTrip(reservation.getReservationId());


        // ---------------------------------------------------------
        // 7. User submits the vehicle
        // ---------------------------------------------------------
        System.out.println("Ending Trip...");
        selectedStore.endTrip(reservation.getReservationId());


        // ---------------------------------------------------------
        // 8. System generates the bill
        // ---------------------------------------------------------
        System.out.println("\nGenerating bill...");
        Bill bill = selectedStore.generateBill(reservation, new DailyBillingStategy(selectedStore.getInventory()));

        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Bill Amount: " + bill.getAmount());


        // ---------------------------------------------------------
        // 8. User makes payment
        // ---------------------------------------------------------
        System.out.println("\nProcessing Payment...");

        Payment payment = selectedStore.makePayment(bill, PaymentMode.UPI);

        System.out.println("\n===== PAYMENT RECEIPT =====");
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Paid Amount: " + payment.getPaymentAmount());
        System.out.println("Payment Mode: " + payment.getPaymentMode());
        System.out.println("============================");

    }
}
