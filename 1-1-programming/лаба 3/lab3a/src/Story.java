import obj.*;

public class Story {
    Person nezn = new Person("Незнайка", true);
    Person ponch = new Person("Пончик", true){
        @Override
        public void scare(){
            System.out.println(getName() + " испугался");
        }
    };
    Aliens alien = new Aliens("gfdBHJS%#@H1", true);
    Trader trader = new Trader("Trader", true);
    Door door = new Door();
    Scafandr scafandrNezn = new Scafandr(nezn);
    Scafandr scafandrPonch = new Scafandr(ponch);
    Items stick = new Items("Stick", 5, trader);
    Items pistol = new Items("Pistol",1, trader);


    public Story(){}
    public void go(){
        this.mystory();
    }
    public void mystory(){
        scafandrNezn.stat();
        scafandrPonch.stat();
        Person.Talking talk = nezn.new Talking();
        talk.talk();
        Person.Thinking think = new Person.Thinking();
        think.think();
        ponch.scare();
        nezn.saw(alien);
        nezn.life();
        nezn.saw(trader);
        trader.trade();
        nezn.myWeapons();
        trader.weaponsCount();
        nezn.pushTheButton(door);
        scafandrNezn.checkScaf(nezn);
        scafandrPonch.checkScaf(ponch);
        nezn.pushTheButton(door);
        nezn.useItem(stick);
        nezn.useItem(pistol);

    }
}

