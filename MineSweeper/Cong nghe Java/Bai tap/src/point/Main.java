package point;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void input(ArrayList<Point2D>a) {
        try {
            File in = new File("src/point/Input.txt");
            Scanner sc = new Scanner(in);
            while (sc.hasNext()) {
                String[] s = sc.nextLine().split(" ");
                if (s.length == 2) {
                    a.add(new Point2D(Double.parseDouble(s[0]), Double.parseDouble(s[1])));
                }
                else if (s.length == 3) {
                    a.add(new Point3D(Double.parseDouble(s[0]), Double.parseDouble(s[1]), Double.parseDouble(s[2])));
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static double distance2D(ArrayList<Point2D>a) {
        double sum = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).getDimension() == 2) {
                for (int j = i + 1; j < a.size(); j++) {
                    if (a.get(j).getDimension() == 2) {
                        sum += a.get(i).distance(a.get(j));
                    }
                }
            }
        }
        return sum;
    }

    private static double distance3D(ArrayList<Point2D>a) {
        double sum = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).getDimension() == 3) {
                for (int j = i + 1; j < a.size(); j++) {
                    if (a.get(j).getDimension() == 3) {
                        sum += ((Point3D)a.get(i)).distance((Point3D)a.get(j));
                    }
                }
            }
        }
        return sum;
    }

    private static void symmetryList(ArrayList<Point2D>a) {
        ArrayList<Point2D>res = new ArrayList<>();
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).getDimension() == 2) {
                for (int j = i + 1; j < a.size(); j++) {
                    if (a.get(j).getDimension() == 2 && a.get(i).isSymmetry(a.get(j))) {
                        res.add(a.get(i));
                        res.add(a.get(j));
                    }
                }
            }
        }
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i).getDimension() == 3) {
                for (int j = i + 1; j < a.size(); j++) {
                    if (a.get(j).getDimension() == 3 && ((Point3D)a.get(i)).isSymmetry((Point3D)a.get(j))) {
                        res.add(a.get(i));
                        res.add(a.get(j));
                    }
                }
            }
        }
        for (int i = 0; i < res.size() - 1; i += 2) {
            System.out.println(res.get(i).toString() + "   " + res.get(i + 1).toString());
        }
    }

    public static void main(String[] args) {
        ArrayList<Point2D>a = new ArrayList<>();
        input(a);
        System.out.println(distance2D(a));
        System.out.println(distance3D(a));
        symmetryList(a);
        a.get(0).tinhtien(5, 5);
        ((Point3D)a.get(1)).tinhtien(5, 5, 5);
        System.out.println(a.get(0).toString());
        System.out.println(a.get(1).toString());
    }
}
