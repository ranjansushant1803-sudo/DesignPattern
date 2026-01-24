package LLD.Designs.VehicleRentalSystem.Payments;

public class Payment {
    private int paymentId;
    private int billId;
    private double paymentAmount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public Payment(int paymentId, int billId, double paymentAmount, PaymentMode paymentMode) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.paymentAmount = paymentAmount;
        this.paymentMode = paymentMode;
        this.paymentStatus = PaymentStatus.Pending;
    }

    public void setPaymentStatus(PaymentStatus status) {
        this.paymentStatus = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
