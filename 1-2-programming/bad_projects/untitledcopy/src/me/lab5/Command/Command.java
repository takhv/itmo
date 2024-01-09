package me.lab5.Command;

/**
 * Интерфейс команд
 * @author takhvatulin
 */
public interface Command {
    String getDescription();
    String getName();
    boolean execute(String argument);
}
