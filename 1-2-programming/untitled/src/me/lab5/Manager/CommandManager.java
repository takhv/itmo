package me.lab5.Manager;

import me.lab5.Command.*;
import me.lab5.Utility.Mode;
import me.lab5.Utility.SpaceMarinesAsker;
import me.lab5.Utility.FileHanding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    Map<String, Command> commands = new HashMap<>();

    public CommandManager(CollectionManager collectionManager, FileHanding fileHanding, SpaceMarinesAsker spaceMarinesAsker, Mode mode) {
        ArrayList<Command> commandsForHelpCommand = new ArrayList<>();
        commandsForHelpCommand.add(new HelpCommand(commandsForHelpCommand));
        commandsForHelpCommand.add(new InfoCommand(collectionManager));
        commandsForHelpCommand.add(new ShowCommand(collectionManager));
        commandsForHelpCommand.add(new AddCommand(collectionManager, spaceMarinesAsker));
        commandsForHelpCommand.add(new UpdateByIdCommand(collectionManager, spaceMarinesAsker));
        commandsForHelpCommand.add(new RemoveByIdCommand(collectionManager));
        commandsForHelpCommand.add(new ClearCommand(collectionManager));
        commandsForHelpCommand.add(new SaveCommand(fileHanding, collectionManager));
        commandsForHelpCommand.add(new ExecuteScriptCommand(fileHanding, mode));
        commandsForHelpCommand.add(new ExitCommand());
        //commandsForHelpCommand.add(new AddIfMax());
        commandsForHelpCommand.add(new RemoveGreaterCommand(collectionManager));
        commandsForHelpCommand.add(new RemoveLowerCommand(collectionManager));
        //commandsForHelpCommand.add(new FilterStartsWithAchievements());
        //commandsForHelpCommand.add(new PrintAscending());
        //commandsForHelpCommand.add(new PrintFieldAscendingWeaponTypeCommand());


        commands.put("help", new HelpCommand(commandsForHelpCommand));
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("add", new AddCommand(collectionManager, spaceMarinesAsker));
        commands.put("update", new UpdateByIdCommand(collectionManager, spaceMarinesAsker));
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand(fileHanding, mode));
        commands.put("exit", new ExitCommand());
        commands.put("save", new SaveCommand(fileHanding, collectionManager));
        //commands.put("add_if_max", new AddIfMax());
        commands.put("remove_greater", new RemoveGreaterCommand(collectionManager));
        commands.put("remove_lower", new RemoveLowerCommand(collectionManager));
        //commands.put("filter_starts_with_achievements", new FilterStartsWithAchievements());
        //commands.put("print_ascending", new PrintAscending());
        //commands.put("print_field_ascending_weapon_type", new PrintFieldAscendingWeaponTypeCommand());
    }

    public void commandSelection(String[] command) {
        Command commandSelect = commands.get(command[0]);
        if (commandSelect != null) {
            if (commandSelect.execute(command[1])) {
                System.out.println("---=== Done! ===---");
            }
        } else {
            commandNotFound();
        }
    }

    public void commandNotFound() {
        System.out.println("Команда не найдена, введите команду help, чтобы получить инструкции");
    }

}
