package me.lab5.Manager;

import me.lab5.Data.SpaceMarine;

import java.time.LocalDate;
import java.util.LinkedHashSet;


public class CollectionManager {
    private LinkedHashSet<SpaceMarine> spaceMarines = new LinkedHashSet<>();
    private LocalDate creatingCollection;

    public CollectionManager() {
        creatingCollection = LocalDate.now();
    }

    public LocalDate getCreatingCollection() {
        return creatingCollection;
    }

    public LinkedHashSet<SpaceMarine> getSpaceMarines() {
        return spaceMarines;
    }

    public void addToCollection(SpaceMarine spaceMarine) {
        spaceMarines.add(spaceMarine);
    }

    public Long generateNextId() {
        if (spaceMarines.isEmpty()) return 1L;
        SpaceMarine lastElem = null;
        for(SpaceMarine i: spaceMarines){lastElem = i;}
        return lastElem.getId()+1;
    }


    @Override
    public String toString() {
        return "spaceMarines=" + spaceMarines;
    }

    public SpaceMarine getElementById(long updateSpaceMarineId) {
        for (SpaceMarine i : spaceMarines) {
            if (i.getId() == updateSpaceMarineId) {
                return i;
            }
        }
        return null;
    }

    public void clearCollection() {
        spaceMarines.clear();
    }

    public void removeSpaceMarine(SpaceMarine removeSpaceMarine) {

        spaceMarines.remove(removeSpaceMarine);
    }

    public void removeGreater(SpaceMarine removeSpaceMarine) {
        System.out.println("Функция еще не реализована");
    }

    public void removeLower(SpaceMarine removeSpaceMarines) {
        System.out.println("Функция еще не реализована");
    }
}
