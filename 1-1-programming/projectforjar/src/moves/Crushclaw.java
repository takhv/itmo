package moves;

import ru.ifmo.se.pokemon.*;

public class Crushclaw extends PhysicalMove {
    public Crushclaw() {
        super(Type.NORMAL, 75, 0.95);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(.1).stat(Stat.DEFENSE, -1));
    }

    @Override
    protected String describe() {
        return "боньк с ослаблением";
    }
}