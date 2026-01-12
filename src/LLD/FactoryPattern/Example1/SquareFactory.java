package LLD.FactoryPattern.Example1;

public class SquareFactory extends ShapeFactory1{

    @Override
    public Shape createShape() {
        return new Square();
    }
}
