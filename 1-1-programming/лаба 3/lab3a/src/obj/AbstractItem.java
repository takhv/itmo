package obj;

public abstract class AbstractItem {
    private static int cnt;
    String name;
    String boss;
    int rank = 1;
    public static int getCnt(){
        return cnt;
    }
    public AbstractItem(){
        cnt++;
    }
    public AbstractItem(String name, int rank, String boss){
        this();
        this.name = name;
        if(rank >= 1 && rank <= 5) {
            this.rank = rank;
        }
        this.boss = boss;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getRank(){
        return rank;
    }
    public void setBoss(String boss){
        this.boss = boss;
    }
    public String getBoss(){
        return boss;
    }

}

