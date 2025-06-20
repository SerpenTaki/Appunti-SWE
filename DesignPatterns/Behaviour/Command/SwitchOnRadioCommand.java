package Behaviour.Command;

public class SwitchOnRadioCommand implements Command{
    private final Radio radio;

    public SwitchOnRadioCommand(Radio radio){
        this.radio = radio;
    }

    @Override
    public void execute() {
        radio.switchOn();
    }
}
