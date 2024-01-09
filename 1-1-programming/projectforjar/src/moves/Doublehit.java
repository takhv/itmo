package moves;

import ru.ifmo.se.pokemon.*;

public class Doublehit extends PhysicalMove {
    public Doublehit() {
        super(Type.NORMAL, 35, 0.90, 1, 2);
    }

    @Override
    protected String describe() {
        return "дабл боньк";
    }
}
