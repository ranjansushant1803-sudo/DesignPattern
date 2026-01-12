package LLD.FactoryPattern.Example1;

public class RectangleFactory extends ShapeFactory1{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
