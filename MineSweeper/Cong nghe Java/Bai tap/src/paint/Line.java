package paint;

public class Line implements IShape {
    private Point a, b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return a.distance(b); //Chu vi = do dai doan thang tu diem a den diem b
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public void move(double angle, double distance) {
        a.move(angle, distance);
        b.move(angle, distance);
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

    @Override
    public String toString() {
        return "Line {" +
                "a = " + a.toString() +
                ", b = " + b.toString() +
                '}';
    }
}
