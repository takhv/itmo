package me.lab5.Command;

import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.IncorrectScript;
import me.lab5.Manager.CollectionManager;
import me.lab5.Utility.SpaceMarinesAsker;

/**
 * Добавление в коллекцию
 * @author takhvatulin
 */
public class AddCommand extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final SpaceMarinesAsker spaceMarinesAsker;


    public AddCommand(CollectionManager collectionManager, SpaceMarinesAsker spaceMarinesAsker) {
        super("add", "добавляет новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.spaceMarinesAsker = spaceMarinesAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            collectionManager.addToCollection(spaceMarinesAsker.addSpaceMarine(collectionManager.generateNextId()));
            return true;
        }catch (IncorrectScript e){
            return false;
        }
    }
}
