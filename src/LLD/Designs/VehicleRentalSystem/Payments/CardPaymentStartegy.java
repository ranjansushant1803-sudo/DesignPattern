package LLD.Designs.VehicleRentalSystem.Payments;

import LLD.Designs.VehicleRentalSystem.Payments.PaymentStrategy;

public class CardPaymentStartegy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        // Logic for Card payment processing
        System.out.println("Processing Card payment of amount: " + amount);
        return true;
    }
}
