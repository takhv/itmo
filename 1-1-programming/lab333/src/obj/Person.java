package obj;
import obj.*;
import java.util.concurrent.ThreadLocalRandom;

public class Person extends AbstractPerson implements AliveInterface {
    public Person(String name) {
        super(name, true);
        System.out.println("Персонаж " + name + " задержался перед дверью.");
    }

    // во избежание нарушения принципов солид, сделаем отдельный класс
    public class Talking{
        public void talk(){
            System.out.println("\"Привет, меня зовут " + getName() + ". Я хочу увидеть пришельцев!\"");
        }
    }
    @Override
    public void scaf() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
        switch (randomNum) {
            case 0,1:
                System.out.println("Состояние скафандра " + getName() + " - " + ArmorCondition.Critical.getName());
                System.out.println("Воздух начал улетучиваться и " + getName() + " начал задыхаться...");
                setAlive(false);
                if (!getAlive()){
                    System.out.println(getName() + " теперь мертв...");
                } else {System.out.println(getName() + " alive");}
                break;
            case 2,3,4:
                System.out.println("Состояние скафандра " + getName() + " - " + ArmorCondition.Crack.getName());
                System.out.println("Встретить пришельцев не получится, да и лучше надолго не задерживаться...");
                break;
            case 9,10:
                System.out.println("Состояние скафандра " + getName() + " - " + ArmorCondition.Perfect.getName());
                System.out.println("Можно хоть всю жизнь носить! Даже хватит времени познакомиться с пришельцами!");
                break;
            default:
                System.out.println("Состояние скафандра " + getName() + " - " + ArmorCondition.Worn.getName());
                System.out.println("Все в порядке, можно идти искать пришельцев");
                break;
        }
    }

}
