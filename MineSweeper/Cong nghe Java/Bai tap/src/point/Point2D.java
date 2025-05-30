package point;

public class Point2D {
    private double x, y;
    private final int dimension = 2;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(point.Point2D obj) {
        return Math.sqrt((obj.x - x) * (obj.x - x) + (obj.y - y) * (obj.y - y));
    }

    public boolean isSymmetry(point.Point2D obj) {
        return x == -obj.x && y == -obj.y;
    }

    public void tinhtien(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
