package moves;

import ru.ifmo.se.pokemon.*;

public class Lowsweep extends PhysicalMove {
    public Lowsweep(){
        super(Type.FIGHTING, 65, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }

    @Override
    protected String describe() {
        return "low sweep";
    }
}