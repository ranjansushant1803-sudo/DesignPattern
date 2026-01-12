package LLD.DecoratorPattern;

public class Mushroom extends Toppings{
    BasePizza pizza;
    public Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        System.out.println("Mushroom toppings");
        return this.pizza.cost()+20;
    }
}
