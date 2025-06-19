package Creazionali.Abstract_Factory;

public class App {
    public static void main(String[] args) {

        UIFactory uiFactory = selectUI("macos"); // cambiare qui con "win" o con "macos"
        final Window window = uiFactory.buildWindow();
        final Button button = uiFactory.buildButton();
        final Slider slider = uiFactory.buildSlider();
        window.show();
        button.show();
        slider.show();
    }

    private static UIFactory selectUI(String arg) {
        // Using an input parameter, a factory for a particular
        // operating system is selected
        UIFactory uiFactory;
        final String so = arg;
        if ("macos".equals(so)) {
            uiFactory = new MacOsUIFactory();
        } else if ("win".equals(so)) {
            uiFactory = new Windows95UIFactory();
        } else {
            throw new NullPointerException("SO must be specified");
        }
        return uiFactory;
    }
}
