package Behaviour.Command;

public class RemoteControl {
    public void pressButton(Command cmd){
        cmd.execute();
    }
}
