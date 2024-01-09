package Utility;

import Managers.CommandManager;
import Commands.*;
import java.util.Scanner;

public class Programm {
    private final CommandManager commandManager;
    private final Console console;

    public Programm(Console console, CommandManager commandManager){
        this.console = console;
        this.commandManager = commandManager;
    }

    public enum Code{
        OK,
        CANCEL
    }
    public void interactive() {
        Scanner scan = new Scanner(System.in);
        Code commStatus;
        do {
            String[] userCommand;
            userCommand = (scan.nextLine().trim() + " ").split(" ", 2);
            userCommand[1] = userCommand[1].trim();

            commStatus = launch(userCommand);
        } while (commStatus != Code.CANCEL);
    }

    private Code launch(String[] userCommand){
        if(userCommand[0].equals("")) return Code.OK;
        var command = commandManager.getCommands().get(userCommand[0]);

        if(command == null){
            console.printerr("Command not found, use 'help' for more information");
            return Code.CANCEL;
        }
        return Code.OK;
    }
}
