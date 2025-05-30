package paint;

public class Triangle implements IShape {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = perimeter();
        return Math.sqrt(p * (p - a.distance(b)) * (p - b.distance(c)) * (p - c.distance(a)));
    }

    @Override
    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public void move(double angle, double distance) {
        a.move(angle, distance);
        b.move(angle, distance);
        c.move(angle, distance);
    }

    @Override
    public void rotate(double angle) {

    }

    @Override
    public void zoom(double ratio) {

    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "a = " + a.toString() +
                ", b = " + b.toString() +
                ", c = " + c.toString() +
                '}';
    }
}
