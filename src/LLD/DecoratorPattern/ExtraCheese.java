package LLD.DecoratorPattern;

public class ExtraCheese extends Toppings{
    BasePizza pizza;
    public ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        System.out.println("ExtraCheese");
        return this.pizza.cost()+10;
    }
}
