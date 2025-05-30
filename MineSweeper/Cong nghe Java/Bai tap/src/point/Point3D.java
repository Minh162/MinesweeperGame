package point;

public class Point3D extends Point2D {
    private double z;
    private final int dimension = 3;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double distance(Point3D obj) {
        return Math.sqrt((obj.getX() - super.getX()) * (obj.getX() - super.getX()) + (obj.getY() - super.getY()) * (obj.getY() - super.getY()) + (obj.getZ() - z) * (obj.getZ() - z));
    }

    public boolean isSymmetry(Point3D obj) {
        return super.getX() == -obj.getX() && super.getY() == -obj.getY() && z == -obj.z;
    }

    public void tinhtien(double x, double y, double z) {
        super.tinhtien(x, y);
        this.z += z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return super.toString() + " " + z;
    }
}
