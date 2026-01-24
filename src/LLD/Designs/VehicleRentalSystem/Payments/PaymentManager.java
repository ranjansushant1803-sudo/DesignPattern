package LLD.Designs.VehicleRentalSystem.Payments;

import LLD.Designs.VehicleRentalSystem.Payments.PaymentStrategy;

import java.util.concurrent.ConcurrentHashMap;

public class PaymentManager {
    private ConcurrentHashMap<Integer, Payment> payments; // paymentId -> Payment
    private PaymentStrategy paymentStrategy;

    public PaymentManager() {
        this.payments = new ConcurrentHashMap<>();
    }

    public void setPaymentStrategy(PaymentMode paymentMode) {
        if(paymentMode==PaymentMode.UPI) {
            paymentStrategy = new UPIPaymentStrategy();
        } else if(paymentMode==PaymentMode.CARD) {
            paymentStrategy = new CardPaymentStartegy();
        } else if(paymentMode==PaymentMode.CASH) {
            paymentStrategy = new CashPaymentStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported payment mode.");
        }
    }

    public Payment processPayment(int billId, double amount, PaymentMode paymentMode) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        setPaymentStrategy(paymentMode);
        boolean paymentSuccess = paymentStrategy.pay(amount);
        if(!paymentSuccess) {
            throw new RuntimeException("Payment processing failed.");
        }
        Payment payment = new Payment(payments.size() + 1, billId, amount, paymentMode);
        payment.setPaymentStatus(PaymentStatus.Completed);
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

}
