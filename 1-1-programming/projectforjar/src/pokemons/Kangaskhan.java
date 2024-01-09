package pokemons;

import moves.Doublehit;
import moves.Thunderbolt;
import moves.Crushclaw;
import moves.Confide;
import ru.ifmo.se.pokemon.*;

public class Kangaskhan extends Pokemon {
    public Kangaskhan(String name, int level) {
        super(name, level);
        
        this.setType(Type.NORMAL);
        this.setStats(105, 95, 80, 40, 80, 90);
        this.setMove(new Doublehit(), new Thunderbolt(), new Crushclaw(), new Confide());
    }
}