package obj;
import java.util.ArrayList;
import java.util.Random;

public class Scafandr{
    private Person p;
    public Scafandr(Person p){
        this.p = p;
    }
    public ArmorCondition randomArmor;
    public Person getPerson(){
        return p;
    }
    public void stat(){
        ArrayList<ArmorCondition> status = new ArrayList<>();
        status.add(ArmorCondition.Crack);
        status.add(ArmorCondition.Critical);
        status.add(ArmorCondition.Worn);
        status.add(ArmorCondition.Perfect);
        Random randomForArmor = new Random();
        randomArmor = status.get(randomForArmor.nextInt(4));
        System.out.println("Состояние скафандра "+ p.getName() +": " + randomArmor);
    }
    public void checkScaf(Person p){
        if(Door.isOpen) {
            if (randomArmor == ArmorCondition.Crack) {
                System.out.println("Воздух улетучился");
                p.die();
            } else if (randomArmor == ArmorCondition.Critical) {
                System.out.println("У "+p.getName()+" мало времени");
            } else if (randomArmor == ArmorCondition.Worn) {
                System.out.println("У " +p.getName()+" все вроде неплохо");
            } else if (randomArmor == ArmorCondition.Perfect) {
                System.out.println("У "+p.getName()+" все замечательно");
            }
        }
    }
}

