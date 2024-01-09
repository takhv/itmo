import Commands.Help;
import Managers.CommandManager;
import Utility.BasedConsole;
import Utility.Enter;
import Utility.Programm;

import java.util.Scanner;

/**
 * Main-class
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Enter.setScan(new Scanner(System.in));
        var console = new BasedConsole();

        if(args.length == 0){
            console.println("You didnt enter command...");
            System.exit(1);
        }

        var commandManager = new CommandManager(){{
            newComm("help", new Help(console, this));
        }};

        new Programm(console, commandManager).interactive();
    }
}