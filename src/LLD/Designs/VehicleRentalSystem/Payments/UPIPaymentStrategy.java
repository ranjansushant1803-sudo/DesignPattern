package LLD.Designs.VehicleRentalSystem.Payments;

import LLD.Designs.VehicleRentalSystem.Payments.PaymentStrategy;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        // Logic for UPI payment processing
        System.out.println("Processing UPI payment of amount: " + amount);
        return true;
    }
}
