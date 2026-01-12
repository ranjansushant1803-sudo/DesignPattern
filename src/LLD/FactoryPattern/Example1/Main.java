package LLD.FactoryPattern.Example1;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapefactory = new ShapeFactory();
        Shape shapeObj = shapefactory.getShape("Circle");
        shapeObj.draw();

        ShapeFactory1 factory = new SquareFactory();
        factory.drawShape();

    }
}
