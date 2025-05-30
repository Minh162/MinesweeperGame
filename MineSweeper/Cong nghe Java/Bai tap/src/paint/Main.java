package paint;

public class Main {
    private static void run() {
        IShape[] a = new IShape[5];
        a[0] = new Point(1.0, 2.0);
        a[1] = new Circle(new Point(1.0, 2.0), 4.0);
        a[2] = new Line(new Point(-1.0, 5.0), new Point(4.0, 2.0));
        a[3] = new Triangle(new Point(1.0, 1.0), new Point(3.0, 1.0), new Point(2.0, 5.0));
        a[4] = new Rectangle(new Point(1.0, 1.0), new Point(4.0, 1.0), new Point(4.0, 3.0), new Point(1.0, 3.0));
        minmaxArea(a);
    }

    private static void minmaxArea(IShape[] a) {
        double minArea = a[0].area(), maxArea = a[0].area(), areaSum = 0, perimeterSum = 0;
        int minAreaPos = 0, maxAreaPos = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].toString());
            double area = a[i].area(), perimeter = a[i].perimeter();
            areaSum += area;
            perimeterSum += perimeter;
            if (area < minArea) {
                minArea = area;
                minAreaPos = i;
            }
            if (area > maxArea) {
                maxArea = area;
                maxAreaPos = i;
            }
            System.out.println("Dien tich = " + area);
            System.out.println("Chu vi = " + perimeter + "\n");
        }
        System.out.println("Tong dien tich = " + areaSum);
        System.out.println("Tong chu vi = " + perimeterSum);
        System.out.println("Hinh co dien tich lon nhat: " + a[maxAreaPos].toString());
        System.out.println("Hinh co dien tich nho nhat: " + a[minAreaPos].toString());
    }

    public static void main(String[] args) {
        run();
    }
}
