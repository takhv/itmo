package obj;

public abstract class AbstractPerson implements PersonInterface {
    private final String name;
    private boolean isAlive;
    static int weaponsCount;
    public AbstractPerson(String name, boolean isAlive){
        this.name = name;
        this.isAlive = isAlive;
    }
    public void scare(){}
    public void die(){
        setAlive(false);
        System.out.println("Персонаж " + getName() + " умер");
    }
    public String getName() {
        return name;
    }
    public Boolean getAlive() {
        return isAlive;
    }
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPerson check = (AbstractPerson) o;
        return hashCode() == check.hashCode();
    }
    @Override
    public String toString(){
        return getName();
    }
}

