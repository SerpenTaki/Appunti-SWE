package Behaviour.Command;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
    public static void main(String[] args){
        final Light light = new Light();
        final SwitchOnCommand switchOnCommand = new SwitchOnCommand(light);
        final SwitchOffCommand switchOffCommand = new SwitchOffCommand(light);
        final RemoteControl remoteControl = new RemoteControl();

        //Il client può interagire con molti oggetti usando una singola interfaccia, il metodo pressButton

        //Accende le luci
        remoteControl.pressButton(switchOnCommand);
        //spegne le luci
        remoteControl.pressButton(switchOffCommand);

        final SwitchOnRadioCommand switchOnRadioCommand = new SwitchOnRadioCommand(new Radio());
        final SexyEnviromentCommand sexyEnviromentCommand = new SexyEnviromentCommand(Arrays.asList(switchOffCommand, switchOnRadioCommand));
        remoteControl.pressButton(sexyEnviromentCommand);
    }
}
