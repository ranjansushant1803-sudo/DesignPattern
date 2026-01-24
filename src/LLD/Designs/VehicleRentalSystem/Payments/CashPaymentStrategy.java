package LLD.Designs.VehicleRentalSystem.Payments;

import LLD.Designs.VehicleRentalSystem.Payments.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        // Logic for Cash payment processing
        System.out.println("Processing Cash payment of amount: " + amount);
        return true;
    }
}
