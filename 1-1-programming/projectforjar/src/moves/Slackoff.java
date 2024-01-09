package moves;

import ru.ifmo.se.pokemon.*;

public class Slackoff extends StatusMove {
    public Slackoff(){
        super(Type.NORMAL, 0, 0);
    }

    protected void applySelfEffects(Pokemon p){
        p.addEffect(new Effect().stat(Stat.HP, (int) p.getStat(Stat.HP)/2));
    }

    @Override
    protected String describe() {
        return "slack off";
    }
}