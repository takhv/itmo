package me.lab5.Command;

import me.lab5.Data.SpaceMarine;
import me.lab5.Exception.IncorrectScript;
import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Manager.CollectionManager;
import me.lab5.Utility.SpaceMarinesAsker;

public class UpdateByIdCommand extends AbstractCommand {
    CollectionManager collectionManager;
    SpaceMarinesAsker spaceMarinesAsker;

    public UpdateByIdCommand(CollectionManager collectionManager, SpaceMarinesAsker spaceMarinesAsker) {
        super("update id {element}", "Обновляет значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.spaceMarinesAsker = spaceMarinesAsker;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new MustBeNotEmptyException();
            long updateLabWorkId = Long.parseLong(argument.trim());
            SpaceMarine updateSpaceMarine = collectionManager.getElementById(updateLabWorkId);
            if (updateSpaceMarine == null) throw new NullPointerException();
            spaceMarinesAsker.setSpaceMarine(updateSpaceMarine);
            if (spaceMarinesAsker.updateById("Хотите изменить имя?")) spaceMarinesAsker.nameAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить координаты?")) spaceMarinesAsker.coordinatesAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить очки здоровья?")) spaceMarinesAsker.healthAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить достижения?")) spaceMarinesAsker.achievementsAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить оружие дальнего боя?")) spaceMarinesAsker.weaponAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить оружие ближнего боя?")) spaceMarinesAsker.meleeWeaponAsk();
            if (spaceMarinesAsker.updateById("Хотите изменить оружие отряд?")) spaceMarinesAsker.chapter();

            return true;
        } catch (MustBeNotEmptyException e) {
            System.out.println("Id не введен");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Космодесантника с таким Id отсутствует");
            return false;
        } catch (IncorrectScript e) {
            return false;
        } catch (NumberFormatException e){
            System.out.println("Вы ввели ошибочный id");
            return false;
        }
    }
}