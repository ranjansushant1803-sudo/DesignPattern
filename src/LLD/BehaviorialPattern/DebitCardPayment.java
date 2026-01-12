package LLD.BehaviorialPattern;

public class DebitCardPayment implements PaymentStrategy{

        String cardNumber;

        DebitCardPayment(String cardNumber){
            this.cardNumber = cardNumber;
        }

        public void pay(int amount){
            System.out.println("Paid amount "+amount+" using debit card "+cardNumber);
        }
}
