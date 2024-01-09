package Data;

import Utility.Verification;

public class Coordinates implements Verification {
    private final Float x; //Поле не может быть null
    private final Double y; //Поле не может быть null

    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean verificate(){
        if (x == null) return false;
        if (y == null) return false;
        return true;
    }
}
