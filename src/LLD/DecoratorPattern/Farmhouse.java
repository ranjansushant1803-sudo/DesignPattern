package LLD.DecoratorPattern;

public class Farmhouse extends BasePizza{
    public int cost(){
        System.out.println("Farmhouse");
        return 300;
    }
}
