package LLD.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new Farmhouse()));
        System.out.println("Pizza cost is "+pizza.cost());
    }
}
