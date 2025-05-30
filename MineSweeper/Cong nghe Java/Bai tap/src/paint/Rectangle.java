package paint;

public class Rectangle implements IShape {
    private Point a, b, c, d;

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return a.distance(b) * b.distance(c);
    }

    @Override
    public double perimeter() {
        return (a.distance(b) + b.distance(c)) * 2;
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
        d.move(angle, distance);
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

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "a = " + a.toString() +
                ", b = " + b.toString() +
                ", c = " + c.toString() +
                ", d = " + d.toString() +
                '}';
    }
}
