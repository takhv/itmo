package commands;

public class AbstractCommand implements Command {
    public final String name;
    public final String description;


    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
