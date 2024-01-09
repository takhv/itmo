package obj;

import java.util.Scanner;

public class Person extends AbstractPerson {
    public Person(String name, boolean isAlive) {
        super(name, isAlive);
        System.out.println("Персонаж " + name + " создан.");
    }
    public void life(){
        if(getAlive()) {
            System.out.println("Сейчас " + getName() + " жив");
        } else {
            System.out.println("Сейчас " + getName() + " мертв");
        }
    }
    public class Talking{
        public void talk(){
            System.out.println("\"Привет, меня зовут " + getName() + ". Я хочу увидеть пришельцев!\"");
        }
    }
    public static class Thinking{
        public void think(){
            System.out.println("\"Интересно, каким окажется таинственный, неизведанный мир Луны?\"");
        }
    }
    public void saw(AbstractPerson p){
        System.out.println(getName() + " увидел " + p.getName() + "!");
    }
    static Scanner account = new Scanner(System.in);
    static int num;
    public static void buy(){
        System.out.println("*Подтвердите покупку (1 - да, 0 - нет)*: ");
        num = account.nextInt();
        if (num == 1) {
            Trader.tradersWeapons -= 1;
            Person.weaponsCount += 1;
            System.out.println("Вы купили товар");
        }
    }
    public void useItem(Items item){
        if(weaponsCount > 0) {
            System.out.println(getName() +" использовал " + item.getName() + " " + item.getRank() + " степени редкости");
        } else{
            System.out.println(getName()+" have no weapon(s)...");
        }
    }
    public void pushTheButton(Door d){
        if(!Door.isOpen) {
            d.openDoor();
        } else{
            d.closeDoor();
        }
    }
    public void myWeapons(){
        System.out.println(getName()+" have " + weaponsCount + " weapon(s)");
    }
}

