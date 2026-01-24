package LLD.Designs.VehicleRentalSystem.Bills;

public class Bill {
    private int billId;
    private int reservationId;
    private double amount;
    private boolean isPaid=false;

    public Bill(int billId, int reservationId, double amount) {
        this.billId = billId;
        this.reservationId = reservationId;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public void setPaymentSuccess(){
        this.isPaid=true;
    }

    public boolean isPaid(){
        return isPaid;
    }
}
