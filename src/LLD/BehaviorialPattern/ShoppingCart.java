package LLD.BehaviorialPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Integer> items;

    ShoppingCart(){
        items = new ArrayList<>();
    }

    public void addItems(int price){
        items.add(price);
    }

    public int calculateTotal(){
//        int sum=0;
//        for(int item:items)
//            sum+=item;
//        return sum;
        return items.stream().mapToInt(Integer::intValue).sum();
    }

    public void checkout(PaymentStrategy paymentStrategy){
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}
