package LLD.Designs.VehicleRentalSystem.Bills;

import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;
import LLD.Designs.VehicleRentalSystem.Bookings.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BillManager {

    //billId -> Bill
    private ConcurrentHashMap<Integer,Bill> bills;
    BillingStrategy billingStrategy;

    public BillManager() {
        bills = new ConcurrentHashMap<>();
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation reservation) {
        double totalAmount = billingStrategy.calculateBillAmount(reservation);
        Bill bill = new Bill(bills.size()+1, reservation.getReservationId(), totalAmount);
        return bill;
    }

}
