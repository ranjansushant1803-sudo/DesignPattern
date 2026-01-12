package LLD.FactoryPattern.Example1;

public abstract class ShapeFactory1 {
    public abstract Shape createShape();

    public void drawShape(){
        Shape shape = createShape();
        System.out.println("from factory");
        shape.draw();
    }
}
