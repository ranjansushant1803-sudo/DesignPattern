package LLD.FactoryPattern.Example1;

public class ShapeFactory {

    Shape getShape(String input){
        switch (input){
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Rectangle":
                return new Rectangle();
            default:
                return null;
        }
    }
}
