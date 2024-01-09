package pokemons;

import moves.Thunderwave;
import moves.Facade;
import moves.Chargebeam;
import ru.ifmo.se.pokemon.*;

public class Shuppet extends Pokemon{
    public Shuppet(String name, int level){
        super(name, level);
        
        this.setType(Type.GHOST);
        this.setStats(44, 75, 35, 63, 33, 45);
        this.setMove(new Thunderwave(), new Facade(), new Chargebeam());
    }
}
