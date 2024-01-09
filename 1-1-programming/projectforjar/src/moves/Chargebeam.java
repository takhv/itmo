package moves;

import ru.ifmo.se.pokemon.*;

public class Chargebeam extends SpecialMove {
    public Chargebeam() {
        super(Type.ELECTRIC, 50, 0.9);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.addEffect(new Effect().chance(.7).stat(Stat.SPECIAL_ATTACK, +1));
    }

    @Override
    protected String describe() {
        return "бзбззбзззззбзбззббззззз";
    }
}
