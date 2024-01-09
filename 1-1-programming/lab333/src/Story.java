import obj.*;

public class Story {
    Person pers = new Person("Незнайка");
    Aliens alien = new Aliens("gfdBHJS%#@H1");
    public Story(){}
    public void go(){
        this.mystory();
    }
    public void mystory(){
        Person.Talking talk = pers.new Talking();
        talk.talk();
        pers.scaf();
        alien.scaf();
    }
}
