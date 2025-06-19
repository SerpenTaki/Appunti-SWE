package Creazionali.Abstract_Factory;

public class Windows95UIFactory implements UIFactory {
    @Override
    public Button buildButton(){
        return new Windows95Button();
    }

    @Override
    public Window buildWindow(){
        return new Windows95Window();
    }

    @Override
    public Slider buildSlider(){
        return new Windows95Slider();
    }
}
