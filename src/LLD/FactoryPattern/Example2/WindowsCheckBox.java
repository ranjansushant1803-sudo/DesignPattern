package LLD.FactoryPattern.Example2;

public class WindowsCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Windows checkbox");
    }
}
