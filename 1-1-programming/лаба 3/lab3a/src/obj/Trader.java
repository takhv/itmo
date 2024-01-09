package obj;

import java.util.Objects;
import java.util.Scanner;

public class Trader extends AbstractPerson{
    public Trader(String name, boolean isAlive) {
        super(name, true);
    }
    static int tradersWeapons;
    static Scanner buyOrNot = new Scanner(System.in);
    static String decision;
    public void trade(){
        tradersWeapons = Items.getCnt();
        System.out.println("trading...");
        System.out.println("Количество товаров у " + getName() + ": " + tradersWeapons);
        if(tradersWeapons > 0) {
            System.out.println("+/-: ");
            decision = buyOrNot.nextLine();
            if (!(Objects.equals(decision, "+") || Objects.equals(decision, "-"))) {
                try {
                    throw new TradeException();
                } catch (TradeException e) {
                    System.out.println("Вы ввели неправильное значение!");
                }
            }
            if (Objects.equals(decision, "+")) {
                Person.buy();
            }
        }
    }
    public void weaponsCount(){
        System.out.println("Количество товаров у " + getName() + ": " + tradersWeapons);
    }
}

