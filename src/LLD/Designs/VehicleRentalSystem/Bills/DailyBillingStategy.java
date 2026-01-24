package LLD.Designs.VehicleRentalSystem.Bills;

import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;
import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleInventory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DailyBillingStategy implements BillingStrategy{
    VehicleInventory vehicleInventory;

    public DailyBillingStategy(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    @Override
    public double calculateBillAmount(Reservation reservation) {

        LocalDate start = reservation.getBookedFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = reservation.getBookedTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Long days =  ChronoUnit.DAYS.between(start, end);

        double dailyRate = vehicleInventory.getVehicle(reservation.getVehicleId()).getDailyRentalCost();

        return days * dailyRate;
    }
}
