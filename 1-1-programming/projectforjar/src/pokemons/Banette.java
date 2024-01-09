package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Banette extends Shuppet{
    public Banette(String name, int level){
        super(name, level);
        
        this.setType(Type.GHOST);
        this.setStats(64, 155, 65, 83, 63, 65);
        this.setMove(new Thunderwave(), new Facade(), new Chargebeam(), new Shadowclaw());
    }
}