package LLD.Designs.VehicleRentalSystem;

import LLD.Designs.VehicleRentalSystem.Bills.Bill;
import LLD.Designs.VehicleRentalSystem.Bills.BillManager;
import LLD.Designs.VehicleRentalSystem.Bills.BillingStrategy;
import LLD.Designs.VehicleRentalSystem.Bills.DailyBillingStategy;
import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;
import LLD.Designs.VehicleRentalSystem.Bookings.ReservationManager;
import LLD.Designs.VehicleRentalSystem.Bookings.ReservationType;
import LLD.Designs.VehicleRentalSystem.Payments.*;
import LLD.Designs.VehicleRentalSystem.Vehicles.Vehicle;
import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleInventory;
import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleType;

import java.util.Date;
import java.util.List;

public class Store {
    int storeId;
    String storeName;
    Location location;
    VehicleInventory vehicleInventory;
    ReservationManager reservationManager;
    BillManager billManager;
    PaymentManager paymentManager;

    public Store(int storeId, String storeName, Location location) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.vehicleInventory = new VehicleInventory();
        this.reservationManager = new ReservationManager(this.vehicleInventory);
        this.billManager = new BillManager();
        this.paymentManager = new PaymentManager();
    }

    public List<Vehicle> getAvailableVehicles(VehicleType vehicleType, Date fromDate, Date toDate){
        return vehicleInventory.getAvailableVehicles(vehicleType,fromDate,toDate);
    }

    public void addVehicleToInventory(Vehicle vehicle){
        vehicleInventory.addVehicle(vehicle);
    }

    public void removeVehicleFromInventory(Vehicle vehicle){
        vehicleInventory.removeVehicle(vehicle);
    }

    public Reservation createReservation(int vehicleId, int userId, Date from, Date to, ReservationType reservationType){
        return reservationManager.makeReservation(vehicleId,userId,from,to,reservationType);
    }

    public void cancelReservation(int reservationId){
        reservationManager.cancelReservation(reservationId);
    }

    public void startTrip(int reservationId){
        reservationManager.startTrip(reservationId);
    }

    public void endTrip(int reservationId){
        reservationManager.endTrip(reservationId);
    }

    public Bill generateBill(Reservation reservation, BillingStrategy billingStrategy){
        billManager.setBillingStrategy(billingStrategy);
        return billManager.generateBill(reservation);
    }

    public Payment makePayment(Bill bill, PaymentMode paymentMode){
        Payment payment = paymentManager.processPayment(bill.getBillId(), bill.getAmount(), paymentMode);
        if(payment.getPaymentStatus() == PaymentStatus.Completed){
            bill.setPaymentSuccess();
        }
        return payment;
    }

    public int getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public Location getLocation() {
        return location;
    }

    public VehicleInventory getInventory() {
        return vehicleInventory;
    }

}
