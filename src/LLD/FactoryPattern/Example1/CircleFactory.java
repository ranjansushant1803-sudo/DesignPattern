package LLD.FactoryPattern.Example1;

public class CircleFactory extends ShapeFactory1 {
    public Shape createShape(){
        return new Circle();
    }
}
