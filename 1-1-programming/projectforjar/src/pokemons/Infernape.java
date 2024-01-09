package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Infernape extends Monferno{
    public Infernape(String name, int level){
        super(name, level);
        
        this.setType(Type.FIRE, Type.FIGHTING);
        this.setStats(76, 104, 71, 104, 71, 108);
        this.setMove(new Fireblast(), new Shadowclaw(), new Slackoff(), new Lowsweep());
    }
}