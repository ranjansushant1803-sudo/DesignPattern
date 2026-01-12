package LLD.FactoryPattern.Example2;

public class Main {
    public static void main(String[] args) {
        GUIDesign design1 = new MacFactory();
        Button btn1 = design1.createButton();
        CheckBox cb1 = design1.createCheckBox();
        btn1.paint();
        cb1.paint();

        GUIDesign design2 = new WindowsFactory();
        Button btn2 = design2.createButton();
        CheckBox cb2 = design2.createCheckBox();
        btn2.paint();
        cb2.paint();

    }
}
