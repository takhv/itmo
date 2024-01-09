package obj;

public class Aliens extends AbstractPerson {
    public Aliens(String name, boolean isAlive){
        super(name, true);
        System.out.println("Пришелец " + name + " существует");
    }

}

