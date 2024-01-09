package Commands;

import Managers.CommandManager;
import Utility.Console;

public class Help extends Command {
    private final Console console;
    private final CommandManager commandManager;

    public Help(Console console, CommandManager commandManager){
        super("help", "помощь с командами");
        this.console = console;
        this.commandManager = commandManager;
    }

    public boolean execute(String[] args){
        if(!args[1].isEmpty()){
            System.out.println("You use " + getName());
            return false;
        }
        commandManager.getCommands().values().forEach(command -> {
            console.print(command.getName(), command.getDescription());
        });
        return true;
    }
}