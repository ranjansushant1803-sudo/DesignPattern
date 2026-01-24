package LLD.Designs.VehicleRentalSystem.Bills;

import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;

public interface BillingStrategy {
    double calculateBillAmount(Reservation reservation);
}
