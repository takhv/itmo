package me.lab5.Command;

import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.MustBeEmptyException;
import me.lab5.Manager.CollectionManager;

public class ShowCommand extends AbstractCommand{
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        super("show", "выводит в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager =collectionManager;
    }
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new MustBeEmptyException();
            if (collectionManager.getSpaceMarines().size() == 0) {
                System.out.println("Коллекция пуста");
            }
            for (SpaceMarine i: collectionManager.getSpaceMarines()) {System.out.println(i);}
            return true;
        }catch (MustBeEmptyException e) {
            System.out.println("Команда вводится без аргумента");
            return false;
        }
    }
}
