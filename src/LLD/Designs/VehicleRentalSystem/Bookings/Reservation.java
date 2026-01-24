package LLD.Designs.VehicleRentalSystem.Bookings;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int userId;
    private int vehicleId;
    private Date bookedFrom;
    private Date bookedTo;
    private ReservationStatus reservationStatus;
    private ReservationType reservationType;

    public Reservation(int reservationId, int userId, int vehicleId, Date bookedFrom, Date bookedTo, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.reservationStatus = ReservationStatus.Scheduled;
        this.reservationType = reservationType;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public Date getBookedFrom() {
        return bookedFrom;
    }

    public Date getBookedTo() {
        return bookedTo;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }
}
