package LLD.Designs.VehicleRentalSystem.Vehicles;

import LLD.Designs.VehicleRentalSystem.Bookings.Reservation;
import LLD.Designs.VehicleRentalSystem.Bookings.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleInventory {

    private ReservationRepository reservationRepository;
    //vehicleId -> vehicles
    private ConcurrentHashMap<Integer, Vehicle> vehicles;

    //vehicleId -> List<reservationIds booked for this vehicle> vehicle can be reservered multiple times for different dates
    private ConcurrentHashMap<Integer,List<Integer>> vehicleBookingsList;

    public VehicleInventory() {
        this.vehicles = new ConcurrentHashMap<>();
        this.vehicleBookingsList = new ConcurrentHashMap<>();
    }

    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.putIfAbsent(vehicle.getVehicleId(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle.getVehicleId());
    }

    public Vehicle getVehicle(int vehicleId) {
        return vehicles.get(vehicleId);
    }

    public boolean isVehicleAvailable(int vehicleId, Date from, Date to) {
        if(vehicleBookingsList.contains(vehicleId)){
            List<Integer> reservationIds = vehicleBookingsList.get(vehicleId);
            for(Integer reservationId : reservationIds){
                Reservation reservation = reservationRepository.getReservationDetailsById(reservationId);
                if(!(to.before(reservation.getBookedFrom()) || from.after(reservation.getBookedTo()))){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Vehicle> getAvailableVehicles(VehicleType vehicleType, Date from, Date to) {
        return vehicles.values().stream()
                .filter(vehicle -> vehicle.getVehicleType() == vehicleType && vehicle.getVehicleStatus() == VehicleStatus.Available)
                .filter(vehicle -> isVehicleAvailable(vehicle.getVehicleId(), from, to))
                .toList();
    }

    public boolean bookVehicle(int vehicleId, int reservationId, Date from, Date to) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if(vehicle == null || vehicle.getVehicleStatus() != VehicleStatus.Available) {
            return false;
        }
        vehicle.setVehicleStatus(VehicleStatus.Booked);
        vehicleBookingsList.putIfAbsent(vehicleId, new ArrayList<>());
        vehicleBookingsList.get(vehicleId).add(reservationId);
        return true;
    }

    public void releaseVehicle(int vehicleId,int reservationId) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if(vehicle != null) {
            List<Integer> reservationIds = vehicleBookingsList.get(vehicleId);
            if(reservationIds != null) {
                reservationIds.remove(Integer.valueOf(reservationId));
            }
            if(reservationIds == null || reservationIds.isEmpty()) {
                vehicleBookingsList.remove(vehicleId);
                vehicle.setVehicleStatus(VehicleStatus.Available);
            }
        }
    }


}
