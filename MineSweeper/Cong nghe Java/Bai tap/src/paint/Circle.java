package paint;

public class Circle implements IShape {
    private Point O;
    private double r;

    public Circle(Point o, double r) {
        O = o;
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public void move(double angle, double distance) {
        O.move(angle, distance);
    }

    @Override
    public void rotate(double angle) {
        //Hinh tron xoay the nao cung van the
    }

    @Override
    public void zoom(double ratio) {
        r *= Math.sqrt(ratio);
    }

    public Point getO() {
        return O;
    }

    public void setO(Point o) {
        O = o;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle {" +
                "O = " + O.toString() +
                ", r = " + r +
                '}';
    }
}
