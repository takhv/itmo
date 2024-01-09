package moves;

import ru.ifmo.se.pokemon.*;

public class Shadowclaw extends PhysicalMove {
    public Shadowclaw(){
        super(Type.GHOST, 70, 1);
    }

    @Override
    protected String describe() {
        return "shadow claw";
    }
}