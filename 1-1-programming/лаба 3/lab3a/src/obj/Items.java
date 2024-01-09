package obj;

public class Items extends AbstractItem{
    public Items(String name, int rank, Trader boss) {
        super(name, rank, boss.getName());
    }
}

