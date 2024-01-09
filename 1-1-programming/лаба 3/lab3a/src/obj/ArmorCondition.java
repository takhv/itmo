package obj;
public enum ArmorCondition {
    Critical("критическое"),
    Crack("плачевное"),
    Worn("нормальное"),
    Perfect("великолепное");
    private final String name;
    ArmorCondition(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

