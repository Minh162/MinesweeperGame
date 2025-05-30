package paint;

public interface IShape {
    double area();
    double perimeter();
    double distance();
    void move(double angle, double distance);
    void rotate(double angle);
    void zoom(double ratio);
}
