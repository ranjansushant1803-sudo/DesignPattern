package LLD.FactoryPattern.Example2;

public class MacFactory implements GUIDesign{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
