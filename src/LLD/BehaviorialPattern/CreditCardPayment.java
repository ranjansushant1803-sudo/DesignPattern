package LLD.BehaviorialPattern;

public class CreditCardPayment implements PaymentStrategy{

    String cardNumber;

    CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public void pay(int amount){
        System.out.println("Paid amount "+amount+" using credit card "+cardNumber);
    }
}
