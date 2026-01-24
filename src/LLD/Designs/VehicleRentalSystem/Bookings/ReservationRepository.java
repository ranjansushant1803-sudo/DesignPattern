package LLD.Designs.VehicleRentalSystem.Bookings;

import java.util.concurrent.ConcurrentHashMap;

public class ReservationRepository {
    //reservationId -> Reservation
    private ConcurrentHashMap<Integer,Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Integer, Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationDetailsById(int reservationId){
        return reservations.get(reservationId);
    }

    public void addReservation(Reservation reservation){
        reservations.putIfAbsent(reservation.getReservationId(), reservation);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation.getReservationId());
    }

}
