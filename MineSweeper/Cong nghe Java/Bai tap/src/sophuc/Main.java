package sophuc;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void nhap(ArrayList<Sophuc>a) {
        try {
            File in = new File("src/sophuc/Input.txt");
            Scanner sc = new Scanner(in);
            while (sc.hasNext()) {
                a.add(new Sophuc(sc.nextDouble(), sc.nextDouble()));
            }
            a.add(new Sophuc());
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static void xuat(ArrayList<Sophuc>a) {
        for (Sophuc i : a) {
            System.out.println(i.toString());
        }
    }

    private static Sophuc tbc(ArrayList<Sophuc>a) {
        Sophuc tong = new Sophuc(0, 0);
        for (Sophuc i : a) {
            tong = tong.cong(i);
        }
        return new Sophuc(tong.getThuc() / a.size(), tong.getAo() / a.size());
    }

    private static Sophuc modulusMax(ArrayList<Sophuc>a) {
        double max = a.get(0).modulus();
        int maxPos = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).modulus() > max) {
                max = a.get(i).modulus();
                maxPos = i;
            }
        }
        return a.get(maxPos);
    }

    private static int demKhongCoPhanAo(ArrayList<Sophuc>a) {
        int dem = 0;
        for (Sophuc i : a) {
            if (i.getAo() == 0) {
                dem++;
            }
        }
        return dem;
    }

    public static void main(String[] args) {
        ArrayList<Sophuc>a = new ArrayList<>();
        nhap(a);
        xuat(a);
        System.out.println("Trung binh cong cac so phuc = " + tbc(a));
        System.out.println("So phuc co modulus lon nhat: " + modulusMax(a));
        System.out.println("So luong so phuc khong co phan ao: " + demKhongCoPhanAo(a));
    }
}
