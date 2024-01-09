package me.lab5.Data;

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Double y; //Поле не может быть null



    public void setX(int x) {
        this.x = x;
    }
    public void setY(double y) {
        if (y == Double.NEGATIVE_INFINITY) throw new IllegalArgumentException();
        if (y == Double.POSITIVE_INFINITY) throw new IllegalArgumentException();
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
