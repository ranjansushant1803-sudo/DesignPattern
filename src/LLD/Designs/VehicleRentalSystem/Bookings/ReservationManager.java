package LLD.Designs.VehicleRentalSystem.Bookings;

import LLD.Designs.VehicleRentalSystem.Vehicles.VehicleInventory;

import java.util.Date;

public class ReservationManager {
    //make a reservation and remove vehicle from available vehicles
    private VehicleInventory vehicleInventory;
    private ReservationRepository reservationRepository;

    public ReservationManager(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
        this.reservationRepository = new ReservationRepository();
        this.vehicleInventory.setReservationRepository(this.reservationRepository);
    }

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public Reservation makeReservation(int vehicleId, int userId, Date from, Date to, ReservationType reservationType) {
        int reservationId = reservationRepository.getAllReservations().size()+1;
        boolean booked = vehicleInventory.bookVehicle(vehicleId,reservationId,from,to);
        if(!booked){
            throw new RuntimeException("Vehicle not available for the selected dates");
        }
        Reservation reservation = new Reservation(reservationId, userId, vehicleId, from, to, reservationType);
        reservationRepository.addReservation(reservation);
        return reservation;
    }

    public void cancelReservation(int reservationId){
        Reservation reservation = reservationRepository.getReservationDetailsById(reservationId);
        if(reservation!=null){
            vehicleInventory.releaseVehicle(reservation.getVehicleId(),reservationId);
            reservation.setReservationStatus(ReservationStatus.Cancelled);
            reservationRepository.removeReservation(reservation);
        }
        else{
            throw new RuntimeException("Invalid Reservation Id");
        }
    }

    public void startTrip(int reservationId){
        Reservation reservation = reservationRepository.getReservationDetailsById(reservationId);
        if(reservation!=null){
            reservation.setReservationStatus(ReservationStatus.InProgress);
        }
        else{
            throw new RuntimeException("Invalid Reservation Id");
        }
    }

    public void endTrip(int reservationId){
        Reservation reservation = reservationRepository.getReservationDetailsById(reservationId);
        if(reservation!=null){
            reservation.setReservationStatus(ReservationStatus.Completed);
            vehicleInventory.releaseVehicle(reservation.getVehicleId(),reservationId);
        }
    }
}
