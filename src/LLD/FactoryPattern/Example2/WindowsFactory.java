package LLD.FactoryPattern.Example2;

public class WindowsFactory implements GUIDesign{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
