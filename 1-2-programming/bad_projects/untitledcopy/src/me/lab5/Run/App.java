package me.lab5.Run;
import me.lab5.Manager.*;
import me.lab5.Utility.*;


import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        String envVariable = System.getenv("");
        Scanner scanner = new Scanner(System.in);
        SpaceMarinesAsker spaceMarinesAsker = new SpaceMarinesAsker(scanner);
        CollectionManager collectionManager = new CollectionManager();
        Console console = new Console(scanner);
        FileHanding fileHanding = new FileHanding(collectionManager, spaceMarinesAsker, envVariable, console);
        Mode mode = new Mode(console, fileHanding);
        spaceMarinesAsker.setMode(mode);


        CommandManager commandManager = new CommandManager(collectionManager, fileHanding, spaceMarinesAsker, mode);
        console.setCommandManager(commandManager);
        fileHanding.setCommandManager(commandManager);
        mode.setMode(ModeEnum.CONSOLE);
        console.consoleReader();
    }
}
