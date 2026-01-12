package LLD.BehaviorialPattern;

public class Main {
    public static void main(String[] args) {
        ShoppingCart sCart = new ShoppingCart();
        sCart.addItems(5000);
        sCart.addItems(3999);
        sCart.addItems(14765);

        sCart.checkout(new CreditCardPayment("1234 5678 9012"));
        sCart.checkout(new DebitCardPayment("9012 3456 7890"));
    }
}
