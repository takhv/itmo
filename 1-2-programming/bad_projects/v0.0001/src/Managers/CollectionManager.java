package Managers;

import Data.SpaceMarine;

import java.util.LinkedHashSet;

public class CollectionManager {
    private LinkedHashSet<SpaceMarine> collection = new LinkedHashSet<SpaceMarine>();

    public LinkedHashSet<SpaceMarine> getCollection() {
        return collection;
    }

}
