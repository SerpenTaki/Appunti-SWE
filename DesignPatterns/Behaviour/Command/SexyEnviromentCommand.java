package Behaviour.Command;

import java.util.List;

public class SexyEnviromentCommand implements Command{
    private List<Command> commands;

    public SexyEnviromentCommand(List<Command> commands){
        this.commands = commands;
    }

    @Override
    public void execute(){
        commands.forEach(Command::execute);
    }
}
