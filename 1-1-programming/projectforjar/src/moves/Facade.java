package moves;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL, 70, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        if (p.getCondition() == Status.BURN || p.getCondition() == Status.PARALYZE){
            super.power = (double) 140;
        }
    }

    @Override
    protected String describe() {
        return "facadeeeeee";
    }

/*
    @Override
    protected void applyOppDamage(Pokemon p, double damage){
        if (){
            damage = 140;
        }
    }

 */
}

