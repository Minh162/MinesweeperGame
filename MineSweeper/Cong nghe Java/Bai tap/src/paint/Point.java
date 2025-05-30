package paint;

public class Point implements IShape {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return 0.0;
    }

    @Override
    public double perimeter() {
        return 0.0;
    }

    @Override
    public double distance() {
        return 0.0;
    }

    @Override
    public void move(double angle, double distance) {
        angle %= 360;
        if (angle < 0) {
            angle = 360 + angle;
        }
        if (angle == 0) {
            x += distance;
        }
        else if (angle == 90) {
            y += distance;
        }
        else if (angle == 180) {
            x -= distance;
        }
        else if (angle == 270) {
            y -= distance;
        }
    }

    @Override
    public void rotate(double angle) {
        //Diem khong xoay duoc
    }

    @Override
    public void zoom(double angle) {
        //Diem khong phong to duoc
    }

    public double distance(Point obj) {
        return Math.sqrt((obj.x - x) * (obj.x - x) + (obj.y - y) * (obj.y - y));
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

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
