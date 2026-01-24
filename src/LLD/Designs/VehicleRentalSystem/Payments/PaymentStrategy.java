package LLD.Designs.VehicleRentalSystem.Payments;

public interface PaymentStrategy {
    boolean pay(double amount);
}
