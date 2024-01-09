package me.lab5.Command;

import me.lab5.Exception.MustBeEmptyException;
import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Manager.CollectionManager;

/**
 * Очищение коллекции
 * @author takhvatulin
 */
public class ClearCommand extends AbstractCommand{
    CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager){
        super("clear", "очищает коллекцию");
        this.collectionManager = collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            if (collectionManager.getSpaceMarines().isEmpty()) throw new MustBeNotEmptyException();
            collectionManager.clearCollection();
            return true;
        } catch (MustBeEmptyException e) {
            System.out.println("Команда вводится без аргумента");
            return false;
        }catch (MustBeNotEmptyException e){
            System.out.println("Коллекция и так пуста");
            return true;
        }
    }
}
