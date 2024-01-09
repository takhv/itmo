package moves;

import ru.ifmo.se.pokemon.*;

public class Thunderwave extends StatusMove {
    public Thunderwave(){
        super(Type.ELECTRIC, 0, 0.9);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().condition(Status.PARALYZE));
        p.addEffect(new Effect().chance(0.75).stat(Stat.ACCURACY, 1));
        p.addEffect(new Effect().stat(Stat.SPEED, (int)p.getStat(Stat.SPEED) / 2));
    }

    @Override
    protected String describe() {
        return "thunderwave";
    }
}
