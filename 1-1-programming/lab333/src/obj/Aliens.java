package obj;

public class Aliens extends AbstractPerson implements AliveInterface {
    public Aliens(String name){
        super(name, true);
        System.out.println("Пришелец " + name + " существует");
    }
    @Override
    public void scaf(){
        System.out.println("А вот " + getName() + " может обходиться без скафандра.");
    }


}
