package me.lab5.Command;

import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Manager.CollectionManager;

/**
 * Удаление по id
 * @author takhvatulin
 */
public class RemoveByIdCommand extends AbstractCommand {
    CollectionManager collectionManager;
    public RemoveByIdCommand(CollectionManager collectionManager) {
            super("remove_by_id id", "удаляет элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new MustBeNotEmptyException();
            long removeSpaceMarineId = Long.parseLong(argument.trim());
            SpaceMarine removeSpaceMarine = collectionManager.getElementById(removeSpaceMarineId);
            if(removeSpaceMarine == null) throw new NullPointerException();
            collectionManager.removeSpaceMarine(removeSpaceMarine);
            System.out.println("Космодесантник успешно удален");
            return true;
        } catch (MustBeNotEmptyException e){
            System.out.println("Id не введен");
            return false;
        } catch (NullPointerException e){
            System.out.println("Космодесантника с таким Id отсутствует");
            return false;
        }
    }
}
