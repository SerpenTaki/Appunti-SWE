package Creazionali.Abstract_Factory;

public class MacOsUIFactory implements UIFactory {
    @Override
    public Button buildButton(){
        return new MacOsButton();
    }

    @Override
    public Window buildWindow(){
        return new MacOsWindow();
    }

    @Override
    public Slider buildSlider(){
        return new MacOsSlider();
    }
}
