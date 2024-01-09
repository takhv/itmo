package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Chimchar extends Pokemon{
    public Chimchar(String name, int level){
        super(name, level);
        
        this.setType(Type.FIRE);
        this.setStats(44, 58, 44, 58, 44, 61);
        this.setMove(new Fireblast(), new Shadowclaw());
    }
}