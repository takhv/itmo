package me.lab5.Command;

import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Manager.CollectionManager;

public class RemoveLowerCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveLowerCommand(CollectionManager collectionManager) {
        super("remove_lower {element}", "удаляет из коллекции все элементы, меньшие, чем заданный");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new MustBeNotEmptyException();
            long removeSpaceMarinesId = Long.parseLong(argument.trim());
            SpaceMarine removeSpaceMarines = collectionManager.getElementById(removeSpaceMarinesId);
            if (removeSpaceMarines == null) throw new NullPointerException();
            collectionManager.removeLower(removeSpaceMarines);
            //System.out.println("Удаления завершены успешно");
            return true;
        } catch (MustBeNotEmptyException e) {
            System.out.println("Id не введен");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Лабораторной работы с таким Id отсутствует");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод");
            return false;
        }
    }
}