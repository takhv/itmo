package obj;
public abstract class AbstractPerson extends Status implements PersonInterface {
    private final String name;
    protected boolean isAlive;
    Status status = new Status();

    public AbstractPerson(String name, boolean isAlive){
        this.name = name;
        this.isAlive = isAlive;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive){
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
        return getName() + " " + getStatus();
    }
}