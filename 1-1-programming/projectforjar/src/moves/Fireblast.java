package moves;

import ru.ifmo.se.pokemon.*;

public class Fireblast extends SpecialMove {
    public Fireblast(){
        super(Type.FIRE, 110, 0.85);
    }

    protected void applyOppDamage(Pokemon p){
        p.addEffect(new Effect().chance(0.1).condition(Status.BURN));
    }

    @Override
    protected String describe() {
        return "fire blast";
    }
}