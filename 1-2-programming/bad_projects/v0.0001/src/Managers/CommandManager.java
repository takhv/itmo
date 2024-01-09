package Managers;

import Commands.Command;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Новая команда
     * @param commName Название команды
     * @param command Команда
     */
    public void newComm(String commName, Command command){
        commands.put(commName, command);
    }

    /**
     * @return Команды
     */
    public Map<String, Command> getCommands(){
        return commands;
    }
}