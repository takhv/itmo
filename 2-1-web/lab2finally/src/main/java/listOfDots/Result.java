package listOfDots;
public class Result {
    double x;
    double y;
    double r;
    String hit;

    public Result(double x, double y, double r, String hit){
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getHit() {
        return hit;
    }

    @Override
    public String toString() {
        return "<tr><td>" + x + "</td><td>" + y + "</td><td>" + r + "</td><td>" + hit + "</td></tr>";
    }
}
